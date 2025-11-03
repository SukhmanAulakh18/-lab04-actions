# Lab 4 – GitHub Actions Workflows (Standalone Project)

This folder is a clean start for Lab 4. It contains a minimal Java 17 + Maven project, JUnit 5 tests, and a ready-to-use GitHub Actions workflow.

If you push this folder as its own GitHub repository, the CI will run automatically on pushes and pull requests.

## What’s here
- `pom.xml` – Maven config (Java 17, JUnit 5, Surefire, JaCoCo)
- `src/main/java/StringProcessor.java` – simple class with two methods
- `src/test/java/StringProcessorTest_Aulakh.java` – tests
- `.github/workflows/ci.yml` – CI pipeline (runs tests, coverage, uploads artifacts)

## Local quick start
1. Open this folder (`lab04-actions`) in VS Code.
2. Run tests locally:
   ```bash
   mvn -q -Dstyle.color=always test
   ```
3. Optional coverage site:
   ```bash
   mvn -q -Dstyle.color=always verify
   open target/site/jacoco/index.html  # macOS
   ```

## Push as a NEW GitHub repository (recommended for this lab)
We’ll initialize a fresh Git repo in this folder and push to a new repo so Actions run at the repo root.

1) Create a new empty repository on GitHub
- Click: GitHub -> "+" (top-right) -> "New repository".
- Name: `lab04-actions` (or any name).
- Visibility: Public (unless instructed otherwise).
- DO NOT add a README, .gitignore, or license (keep it empty).
- Screenshot: New repo creation page just before clicking "Create repository".

2) Initialize and push from your Mac (inside this `lab04-actions` folder)
```bash
git init -b main
git add .
git commit -m "Lab 4: scaffold Java + CI"
git remote add origin https://github.com/<your-username>/<your-repo>.git
# or use SSH if you prefer: git@github.com:<your-username>/<your-repo>.git

git push -u origin main
```
- Screenshot: Terminal showing the first push succeeded (URL + branch set upstream).

3) Verify CI starts automatically (GitHub manual steps)
- Click: Your repo -> "Actions" tab.
- If GitHub asks to enable workflows, click "I understand my workflows" -> "Enable".
- Click into the latest run titled "CI".
- Screenshot: Workflow run page with steps (checkout, setup-java, mvn test, verify, artifacts uploaded).

4) Download artifacts (manual)
- On the run page, scroll to "Artifacts".
- Click `surefire-reports` and `jacoco-site` to download.
- Screenshot: The artifacts section with download links visible.

## Trigger CI via Pull Request (optional but recommended)
1) Create a feature branch locally
```bash
git checkout -b feature/update-readme
```
2) Make a small change (e.g., tweak README heading), then commit and push
```bash
echo "\nSmall tweak for PR demo" >> README.md
git add README.md
git commit -m "docs: small tweak"
git push -u origin feature/update-readme
```
3) Open a PR on GitHub (manual)
- Click: "Compare & pull request" banner, or go to "Pull requests" -> "New pull request".
- Base branch: `main`. Compare: `feature/update-readme`.
- Click "Create pull request".
- Screenshot: PR page showing the diff and the status checks section.

4) See CI checks on PR (manual)
- Click: PR -> "Checks" tab.
- Screenshot: Checks tab showing CI job green (or red if failing) with logs.

5) Merge the PR (manual)
- Click: "Merge pull request" -> "Confirm merge".
- Screenshot: Green "Merged" badge on PR.

6) Pull merged changes locally
```bash
git checkout main
git pull origin main
```
- Screenshot: Terminal with the merge commit pulled.

## Screenshot checklist (exact spots)
1. New repo creation (GitHub) – before clicking Create
2. First push success (terminal)
3. Actions tab showing the CI run list
4. Inside a CI run – steps expanded (setup-java, mvn test)
5. Artifacts section – `surefire-reports` and `jacoco-site` links
6. PR creation page – base/compare and diff
7. PR Checks tab – CI status and logs
8. PR merged confirmation – green badge
9. Local terminal after `git pull` – shows merge commit

## Notes
- If you see “Workflows aren’t being run on this forked repository” banner, click “Enable workflows”.
- If Maven isn’t installed locally, install via Homebrew: `brew install maven`.
- Java 17 JDK required locally; on macOS you can use Temurin (Adoptium).
