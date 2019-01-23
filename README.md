# README LMA Video Annotation Tool
This tool is developed to support the annotation of videos based on Laban Movement Analysis.
The tools shows two videos side-by-side: one with a movement variation and one neutral reference.

The structure of LMA is defined as a directed graph, where questions follow answers:
![](LMADB_graph.png)

The graph itself is stored in an SQLite database (resources\LMAtree.db). The table "Q2A" maps questions to possible answers, while table "A2Q" maps an answer to a follow-up question.

Software originally developed at Simon Fraser University, Vancouver, Canada by Ankit Gupta, Ulysses Bernardet, Sarah Fdili Alaoui, Karen Studd, Karen Bradley, and Thecla Schiphorst.

## Running
Either 
`gradlew.bat run`

or 

upzip `build\distributions\VideoAnnotation_Reliability.zip` and run the file in the `bin` directory


## Building
`gradlew.bat build` (Windows) 
`bash gradlew build` (Linux)


