# BugKiller_App Project Context

Generated: 2026-05-27 01:50 UTC

## Business Purpose
Android arcade-style bug-killing game built around classes like MainActivity, MainView, Bug, LadyBug, and SuperBug.

## System Overview
This repo centers on primary application under `graphify-out`.

## Major Applications
- primary application under `graphify-out`

## Environments
- local development

## Tech Stack
- Java
- Android
- Gradle

## Critical Dependencies
- No package-manager dependencies were parsed.

## Major Workflows
- Arcade bug-killing gameplay with bug entities such as Bug, LadyBug, and SuperBug
- Main activity and view flow for gameplay
- Settings/preferences screen through PrefsFragmentSettings
- Title/menu activity structure
- Score-driven game behavior

## Operational Constraints
- Project maturity is uneven; expect weaker docs, less automation, and more manual assumptions than the active product repos.

## Scaling Constraints
- Likely low-scale or instructional usage; do not overdesign scaling layers that the repo does not currently have.

## Deployment Model
Gradle/Android Studio style local build workflow.

## Important APIs
- No formal API surface is visible; this may be a static or local-only project.

## Important Databases
- No dedicated database is visible from the inspected files.

## Important Queues / Events
- No message queue or explicit event bus is visible; async behavior is local/in-process if present at all.

## Known Technical Debt
- Add randomly appearing super bugs that are larger than regular bugs
- Make super bugs require 4 clicks and award 10 points
- Play a special sound effect when killing a super bug
- Limit super bug frequency to at most once every 20 seconds
- Support random straight-line or zig-zag super bug movement

## Current Architecture Themes
- Tier C repo under the `_personal` workspace
- Graphify-first repository discovery
- preserve current architecture instead of speculative rewrites
