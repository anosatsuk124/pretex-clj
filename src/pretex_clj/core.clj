(ns pretex-clj.core)

(defn tex [& command]
  (if (< (count command) 2)
    (let [com (first command)] (str "\\" com "\n"))
    (let [com (first command) value (second command)] (str "\\" com "{" value "}" "\n"))))

(defn title [statement] (tex "title" statement))

(defn author [statement] (tex "author" statement))

(defn date [statement] (tex "date" statement))

(defn mode [mode statement] (str "\\" "begin{" mode "}\n" statement "\n" "\\end{" mode "}\n"))

(defn math [statement] (mode "math" statement))

(defn displaymath [statement] (mode "displaymath" statement))

(defn document [statement] (mode "document" statement))
