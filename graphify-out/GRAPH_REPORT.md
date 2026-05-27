# Graph Report - BugKiller_App  (2026-05-26)

## Corpus Check
- 35 files · ~72,948 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 211 nodes · 198 edges · 36 communities (16 shown, 20 thin omitted)
- Extraction: 96% EXTRACTED · 4% INFERRED · 0% AMBIGUOUS · INFERRED: 8 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `a06c725d`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- [[_COMMUNITY_Community 0|Community 0]]
- [[_COMMUNITY_Community 1|Community 1]]
- [[_COMMUNITY_Community 2|Community 2]]
- [[_COMMUNITY_Community 3|Community 3]]
- [[_COMMUNITY_Community 4|Community 4]]
- [[_COMMUNITY_Community 5|Community 5]]
- [[_COMMUNITY_Community 6|Community 6]]
- [[_COMMUNITY_Community 7|Community 7]]
- [[_COMMUNITY_Community 8|Community 8]]
- [[_COMMUNITY_Community 9|Community 9]]
- [[_COMMUNITY_Community 10|Community 10]]
- [[_COMMUNITY_Community 11|Community 11]]
- [[_COMMUNITY_Community 15|Community 15]]
- [[_COMMUNITY_Community 16|Community 16]]
- [[_COMMUNITY_Community 17|Community 17]]
- [[_COMMUNITY_Community 18|Community 18]]
- [[_COMMUNITY_Community 19|Community 19]]
- [[_COMMUNITY_Community 20|Community 20]]
- [[_COMMUNITY_Community 21|Community 21]]
- [[_COMMUNITY_Community 22|Community 22]]
- [[_COMMUNITY_Community 23|Community 23]]
- [[_COMMUNITY_Community 24|Community 24]]
- [[_COMMUNITY_Community 25|Community 25]]
- [[_COMMUNITY_Community 26|Community 26]]
- [[_COMMUNITY_Community 27|Community 27]]
- [[_COMMUNITY_Community 28|Community 28]]
- [[_COMMUNITY_Community 29|Community 29]]
- [[_COMMUNITY_Community 30|Community 30]]
- [[_COMMUNITY_Community 31|Community 31]]
- [[_COMMUNITY_Community 32|Community 32]]

## God Nodes (most connected - your core abstractions)
1. `BugKiller_App Project Context` - 16 edges
2. `Primary App` - 15 edges
3. `BugKiller_App Architecture` - 14 edges
4. `MainThread` - 10 edges
5. `MainView` - 10 edges
6. `BugKiller_App` - 10 edges
7. `BugKiller_App Workflows` - 10 edges
8. `BugKiller_App Coding Rules` - 9 edges
9. `PrefsFragmentSettings` - 8 edges
10. `LadyBug` - 7 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Communities (36 total, 20 thin omitted)

### Community 1 - "Community 1"
Cohesion: 0.21
Nodes (3): AppCompatActivity, MainActivity, TitleActivity

### Community 15 - "Community 15"
Cohesion: 0.12
Nodes (16): BugKiller_App Project Context, Business Purpose, Critical Dependencies, Current Architecture Themes, Deployment Model, Environments, Important APIs, Important Databases (+8 more)

### Community 16 - "Community 16"
Cohesion: 0.12
Nodes (15): Critical Workflows, Dangerous Code Paths, Databases Used, Dependencies, Failure Modes, Important Source Files, Inbound APIs, Known Technical Debt (+7 more)

### Community 17 - "Community 17"
Cohesion: 0.13
Nodes (14): Auth Flow, BugKiller_App Architecture, Caching Layers, Deployment Topology, End-to-End Request Flows, Event-Driven Architecture, Failover Behavior, Frontend / Backend Interaction (+6 more)

### Community 18 - "Community 18"
Cohesion: 0.18
Nodes (10): BugKiller_App, Build / inspect, LLM Start Here, Main files, Quick Repo Summary, Resume value, Start here, Status (+2 more)

### Community 19 - "Community 19"
Cohesion: 0.18
Nodes (10): BugKiller_App Workflows, Debugging, Deployment, Feature Rollout, Incident Response, Local Development, Migrations, Observability Investigation (+2 more)

### Community 20 - "Community 20"
Cohesion: 0.2
Nodes (9): API Conventions, Architecture Patterns, BugKiller_App Coding Rules, Database / Migration Patterns, Error Handling / Logging, Naming / Structure, State Management, Testing Conventions (+1 more)

### Community 21 - "Community 21"
Cohesion: 0.29
Nodes (6): BugKiller_App Onboarding, Critical Entrypoints, First Read, How To Start Reasoning, Local Run Baseline, Module Map

### Community 22 - "Community 22"
Cohesion: 0.5
Nodes (3): BugKiller_App Decision Log, Graphify-first repo discovery, Preserve repo separation

### Community 23 - "Community 23"
Cohesion: 0.5
Nodes (3): Critical Entrypoints, Read First, Top-Level Modules

## Knowledge Gaps
- **87 isolated node(s):** `Why this repo exists`, `What this repo does`, `Main files`, `Status`, `Build / inspect` (+82 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **20 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `MainThread` connect `Community 2` to `Community 0`?**
  _High betweenness centrality (0.044) - this node is a cross-community bridge._
- **Why does `MainActivity` connect `Community 1` to `Community 0`?**
  _High betweenness centrality (0.023) - this node is a cross-community bridge._
- **Why does `MainView` connect `Community 0` to `Community 1`?**
  _High betweenness centrality (0.019) - this node is a cross-community bridge._
- **What connects `Why this repo exists`, `What this repo does`, `Main files` to the rest of the system?**
  _87 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Community 15` be split into smaller, more focused modules?**
  _Cohesion score 0.12 - nodes in this community are weakly interconnected._
- **Should `Community 16` be split into smaller, more focused modules?**
  _Cohesion score 0.12 - nodes in this community are weakly interconnected._
- **Should `Community 17` be split into smaller, more focused modules?**
  _Cohesion score 0.13 - nodes in this community are weakly interconnected._