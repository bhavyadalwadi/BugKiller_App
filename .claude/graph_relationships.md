# BugKiller_App Graph Relationships

       ## Service Dependency Graph
       BugKiller_App
-> primary application under `graphify-out`
-> Queues/Events: not present
-> Deployment: Gradle/Android Studio style local build workflow.

       ## Runtime Dependency Graph
       BugKiller_App
-> Runtime: Java
-> Runtime: Android
-> Runtime: Gradle

       ## Database Relationship Graph
       BugKiller_App
-> no dedicated database visible

       ## API Consumer / Provider Graph
       BugKiller_App
-> no formal API contract visible

       ## Queue Publisher / Consumer Graph
       BugKiller_App
-> no broker or queue layer visible

       ## Shared Package Dependency Graph
       BugKiller_App
-> no notable shared package layer beyond app-local dependencies

       ## Deployment Relationship Graph
       BugKiller_App
       - Gradle/Android Studio style local build workflow.

       ## Cross-Repo Relationship Graph
       BugKiller_App
-> no runtime dependency on sibling repos by default
