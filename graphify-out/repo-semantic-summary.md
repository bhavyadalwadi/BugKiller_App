# Repo Semantic Summary - BugKiller_App

Generated: 2026-05-19 21:48 UTC

## What This Repo Is For
Android arcade-style bug-killing game built around classes like MainActivity, MainView, Bug, LadyBug, and SuperBug.

## Snapshot
- Domains: game, mobile app
- Tech stack: Java, Android, Gradle
- Pending state: documented
- Status confidence: high
- Current work guess: Documented pending work centers on adding and tuning the SuperBug gameplay behavior.
- Graph stats: 82 nodes · 84 edges · 15 communities (4 shown, 11 thin omitted)

## Features
- Arcade bug-killing gameplay with bug entities such as Bug, LadyBug, and SuperBug
- Main activity and view flow for gameplay
- Settings/preferences screen through PrefsFragmentSettings
- Title/menu activity structure
- Score-driven game behavior

## Pending
- Add randomly appearing super bugs that are larger than regular bugs
- Make super bugs require 4 clicks and award 10 points
- Play a special sound effect when killing a super bug
- Limit super bug frequency to at most once every 20 seconds
- Support random straight-line or zig-zag super bug movement

## Read First
- `extra.txt`
- `graphify-out/GRAPH_REPORT.md`
- `RoachKiller/build.gradle`

## Likely Entrypoints
- `RoachKiller/app`
- `RoachKiller/build.gradle`
- `extra.txt`

## Main Modules
- `RoachKiller`

## Conservative Suggestions
- Implement the documented SuperBug behavior from extra.txt
- Add a README describing gameplay, controls, and build/run steps

## Evidence Files
- `extra.txt`
- `RoachKiller/build.gradle`
- `graphify-out/GRAPH_REPORT.md`

## Graph Signals
- God nodes: MainThread, MainView, PrefsFragmentSettings, LadyBug, SuperBug
