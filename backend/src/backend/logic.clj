(ns backend.logic
  (:gen-class))

(def edges-test
  [[8 7]
   [7 3]
   [2 1]
   [3 7]
   [4 8]])

(defn edge-to-map [[a b]]
  {a #{b} b #{a}})

(defn edges-to-map [edges]
  (reduce #(merge-with into %1 %2) (map edge-to-map edges)))

(defn is-same-network [node-a node-b edges]
  (let [mapped-edges (edges-to-map edges)]
    (loop [nodes-path [node-a]
           visited-nodes #{node-a}]
      (if (empty? nodes-path)
        false
        (let [current-node (last nodes-path)
              current-children (mapped-edges current-node)
              next-node (first (filter (complement visited-nodes) current-children))]
          (if (contains? current-children node-b)
            true
            (if next-node
              (recur (conj nodes-path next-node)
                     (conj visited-nodes next-node))
              (recur (drop-last nodes-path)
                     visited-nodes))))))))