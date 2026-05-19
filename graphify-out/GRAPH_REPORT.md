# Graph Report - BugKiller_App  (2026-05-19)

## Corpus Check
- 17 files · ~70,757 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 82 nodes · 84 edges · 15 communities (4 shown, 11 thin omitted)
- Extraction: 90% EXTRACTED · 10% INFERRED · 0% AMBIGUOUS · INFERRED: 8 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

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

## God Nodes (most connected - your core abstractions)
1. `MainThread` - 9 edges
2. `MainView` - 9 edges
3. `PrefsFragmentSettings` - 7 edges
4. `LadyBug` - 6 edges
5. `SuperBug` - 6 edges
6. `Bug` - 6 edges
7. `TitleActivity` - 5 edges
8. `MainActivity` - 5 edges
9. `PrefsActivity` - 5 edges
10. `MenuActivity` - 4 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Communities (15 total, 11 thin omitted)

### Community 1 - "Community 1"
Cohesion: 0.28
Nodes (3): AppCompatActivity, MainActivity, TitleActivity

## Knowledge Gaps
- **1 isolated node(s):** `Assets`
  These have ≤1 connection - possible missing edges or undocumented components.
- **11 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `MainThread` connect `Community 2` to `Community 0`?**
  _High betweenness centrality (0.225) - this node is a cross-community bridge._
- **Why does `MainActivity` connect `Community 1` to `Community 0`?**
  _High betweenness centrality (0.111) - this node is a cross-community bridge._
- **What connects `Assets` to the rest of the system?**
  _1 weakly-connected nodes found - possible documentation gaps or missing edges._