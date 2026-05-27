# Primary App

## Responsibility
Main runtime for `BugKiller_App`.

## Dependencies
- Java
- Android
- Gradle

## Inbound APIs
- No formal inbound API is visible.

## Outbound APIs
- No confirmed external provider or downstream API.

## Databases Used
- No dedicated database visible.

## Queues / Topics
- No queue/topic layer visible.

## Critical Workflows
- Arcade bug-killing gameplay with bug entities such as Bug, LadyBug, and SuperBug
- Main activity and view flow for gameplay
- Settings/preferences screen through PrefsFragmentSettings
- Title/menu activity structure
- Score-driven game behavior

## Failure Modes
- Project maturity is uneven; expect weaker docs, less automation, and more manual assumptions than the active product repos.

## Scaling Concerns
- current implementation appears intentionally lightweight
- there is no evidence of multi-service scaling machinery unless repo docs add it

## Operational Concerns
- start from repo-local `.claude/` docs and Graphify summary before code changes
- validate environment assumptions before debugging logic

## Important Source Files
- `RoachKiller/app`
- `RoachKiller/build.gradle`
- `extra.txt`
- `README.md`
- `README.MD`

## Dangerous Code Paths
- Project maturity is uneven; expect weaker docs, less automation, and more manual assumptions than the active product repos.

## Testing Strategy
- No standardized automated test command is visible.

## Known Technical Debt
- Add randomly appearing super bugs that are larger than regular bugs
- Make super bugs require 4 clicks and award 10 points
- Play a special sound effect when killing a super bug
- Limit super bug frequency to at most once every 20 seconds
- Support random straight-line or zig-zag super bug movement
