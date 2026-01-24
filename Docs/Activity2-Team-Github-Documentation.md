# Activity 2 — Team GitHub Documentation

## Orders4U Application

---

|                |                              |
| -------------- | ---------------------------- |
| **Authors**    | Owen Lindsey & Brennan Bania |
| **Course**     | CST-323                      |
| **Instructor** | Professor Sluiter            |
| **Date**       | 24 January 2026              |

---

## Table of Contents

- [Section 1: Repository Setup Screenshots](#section-1-repository-setup-screenshots)
- [Section 2: Branch & Pull Request Workflow Evidence](#section-2-branch--pull-request-workflow-evidence)
- [Section 3: Design Documentation Screenshots (Student 2)](#section-3-design-documentation-screenshots-student-2)
- [Section 4: Backend Development Screenshots (Student 1)](#section-4-backend-development-screenshots-student-1)
- [Section 5: Frontend Development Screenshots (Student 2)](#section-5-frontend-development-screenshots-student-2)
- [Section 6: Testing & Integration Screenshots](#section-6-testing--integration-screenshots)
- [Section 7: Pull Requests](#section-7-pull-requests)
- [Section 8: AI Exploration Summary](#section-8-ai-exploration-summary)
- [Section 9: Reflection](#section-9-reflection)

---

<div style="page-break-after: always;"></div>

## Section 1: Repository Setup Screenshots

### 1.1 GitHub Repository Main Page

> **Caption:** Repository main page showing CST-323-PairPrograming as a public repository.

![Repository Main Page](Photos/repo-main.png)

---

### 1.2 Collaborators List

> **Caption:** GitHub Settings → Collaborators page showing Brennan Bania (@BrennanBania) added as a collaborator with direct access. The repository owner (@omniV1 - Owen Lindsey) has implicit access and doesn't appear in this list.

![Collaborators List](Photos/collaborators.png)

**Access Summary:**
- **@omniV1 (Owen Lindsey)** — Repository Owner
- **@BrennanBania (Brennan Bania)** — Collaborator with push access

---

### 1.3 Commit History Overview

> **Caption:** Complete commit history showing all commits from both team members.

![Commit History](Photos/comit-history.png)

**Timeline Summary:**
- **Jan 13:** Initial commit, README with workflow rules, first PRs merged
- **Jan 15-16:** Backend implementation (UserEntity, UsersRepository, UsersDetailsService)
- **Jan 22:** Frontend implementation (Registration, Login, Admin pages, Navigation)
- **Jan 23:** Final integration and documentation updates

---

<div style="page-break-after: always;"></div>

## Section 2: Branch & Pull Request Workflow Evidence

> **Note:** Feature branches were deleted after successful merges, following professional Git workflow practices. The Pull Request history preserves complete evidence of branch-based development.

### 2.1 Pull Request History 

> **Caption:** GitHub Pull Requests page showing 11 closed PRs from both team members. This demonstrates proper branch-based development workflow where all changes went through pull requests before merging to main. Feature branches were deleted after merge per professional best practices.

![PR History](Photos/pr-history.png)

---

<div style="page-break-after: always;"></div>

## Section 3: Design Documentation (Student 2)

> **Note:** Complete design documentation exists in dedicated files within the `/Docs` folder. This section provides an overview and references to those documents.

### 3.1 Design Documents Overview

Student 2 created three comprehensive design documents before implementation began:

| Document | Purpose | Contents |
|----------|---------|----------|
| [user-feature-design.md](user-feature-design.md) | Feature requirements | User flows, error handling, security boundaries |
| [file-map.md](file-map.md) | Architecture contract | Route mappings, class definitions, method signatures |
| [Wireframe.md](Wireframe.md) | UI specifications | Page layouts, form fields, button actions |

---

### 3.2 Site Map / Application Flow

> **Caption:** Visual site map showing the complete application flow including authentication paths (Login/Register), role-based routing, and admin user management pages.

![Site Map](Photos/CST-323PairProgramming-Design.png)

**From user-feature-design.md — User Flows:**
```
Regular User:  Register → Login → Home Page → Manage Orders
Admin User:    Login → Home Page → Admin Panel → View Users → Edit / Delete
```

---

### 3.3 Wireframes Summary

> **Caption:** Wireframe specifications are documented in [Wireframe.md](Wireframe.md). Each page includes field types, validation rules, and button actions.

**Pages Documented:**
- `login.html` — Centered form with error display area
- `register.html` — Registration with password confirmation
- `admin.html` — User list with avatar, role badges, action buttons
- `editUser.html` — Edit form with role dropdown and status toggle
- `confirmDelete.html` — Delete confirmation with warning message

---

### 3.4 Architecture Documentation

> **Caption:** The [file-map.md](file-map.md) serves as the contract between backend and frontend developers.

**Key User Feature Classes:**

| Class | Location | Purpose |
|-------|----------|---------|
| `UserEntity` | `com.gcu.models` | JPA entity for USERS table |
| `UserModel` | `com.gcu.models` | DTO for form submissions |
| `UsersRepository` | `com.gcu.data` | Spring Data repository |
| `UsersDetailsService` | `com.gcu.data` | Spring Security integration |
| `UsersController` | `com.gcu.controllers` | Auth routes (login/register) |
| `UserAdminController` | `com.gcu.controllers` | Admin management routes |

---

### 3.5 User Flows (Mermaid Diagrams)

> **Caption:** Detailed user flow diagrams are documented in [user-feature-design.md](user-feature-design.md).

**Flows Documented:**
- Registration Flow — Password validation, username uniqueness check
- Login Flow — Credential validation, account enabled check
- Admin Edit User Flow — Self-demotion prevention
- Admin Delete User Flow — Self-deletion prevention

---

### 3.6 Error Handling Specifications

> **Caption:** Error handling design from [user-feature-design.md](user-feature-design.md).

| Page | Error Condition | Message |
|------|-----------------|---------|
| Registration | Passwords don't match | "Passwords do not match" |
| Registration | Username exists | "Username already exists" |
| Login | Invalid credentials | "Invalid username or password" |
| Admin | Self-demotion attempt | "You cannot demote yourself" |

---

<div style="page-break-after: always;"></div>

## Section 4: Backend Development Screenshots (Student 1)

> **Note:** This section contains placeholders for Student 1's backend development screenshots.

### 4.1 UserEntity Commit

> **Caption:** GitHub commit 3c2872a by BrennanBania showing the addition of UserEntity.java with Spring Data annotations (`@Table`, `@Id`) and required fields (id, username, password, role, enabled).

![UserEntity Commit](Photos/userentity-commit.png)

---

### 4.2 UsersRepository Commit

> **Caption:** GitHub commit 370d59b by BrennanBania showing the addition of UsersRepository.java interface for user data access.

![UsersRepository Commit](Photos/usersrepo-commit.png)

---

### 4.3 Spring Security Integration Commit

> **Caption:** GitHub commit 5e02e37 by BrennanBania showing UsersDetailsService.java implementing Spring Security's UserDetailsService interface with loadUserByUsername method, and UsersRepository.java with the findByUsername custom query.

![Security Integration Commit](Photos/security-commit.png)

---

### 4.4 Controllers Commit

> **Caption:** GitHub commit 02c59e0 by BrennanBania showing UserAdminController.java with spec-compliant routes for admin user management including showAdminPanel, editUser, updateUser, confirmDelete, deleteUser, and toggleUserStatus methods.

![Controllers Commit](Photos/controllers-commit.png)

---

### 4.5 Backend Tests Passing

> **Caption:** Terminal output showing all backend tests passing after running `mvn test`. Tests verify repository behavior, security rules, and password encoding.

![Backend Tests](Photos/placeholder-backend-tests.png)

<!-- STUDENT 1: Add screenshot of passing backend tests -->

---

### 4.6 Application Running

> **Caption:** Terminal showing Spring Boot application started successfully without errors.

![App Running](Photos/placeholder-app-running.png)

<!-- STUDENT 1: Add screenshot of application running -->

---

### 4.7 Security Redirect Behavior

> **Caption:** Browser showing redirect to login page when attempting to access /admin/users while unauthenticated. This confirms Spring Security route protection is working correctly.

![Security Redirect](Photos/placeholder-security-redirect.png)

<!-- STUDENT 1: Add screenshot of security redirect to login -->

---

<div style="page-break-after: always;"></div>

## Section 5: Frontend Development Screenshots (Student 2)

### 5.1 Login Page

> **Caption:** Login page rendered at /users/login showing username and password fields with submit button and link to registration.

![Login Page](Photos/login.png)

---

### 5.2 Login Page with Error

> **Caption:** Login page displaying "Invalid username or password" error message when authentication fails. The URL shows `/users/login?error`, demonstrating Spring Security's error handling integration with the custom login template.

![Login Error](Photos/login-error.png)

---

### 5.3 Registration Page

> **Caption:** Registration page at /users/register showing form fields for username, password, and password confirmation.

![Registration Page](Photos/Register.png)

---

### 5.4 Registration Page with Error

> **Caption:** Registration page displaying "Passwords do not match" validation error when the password and confirm password fields don't match. This demonstrates frontend validation feedback to users.

![Registration Error](Photos/register-error.png)

---

### 5.5 Admin User List Page

> **Caption:** Admin panel at /admin showing all registered users with their avatars, usernames, role badges (Admin/User), account status (Enabled/Disabled), and action buttons (Edit/Delete).

![Admin Panel](Photos/AdminPanel.png)

---

### 5.6 Edit User Page

> **Caption:** Edit user form at /admin/editUser/{id} showing pre-populated fields for username, optional password reset, role dropdown, and enabled status checkbox.

![Edit User](Photos/editUser.png)

---

### 5.7 Home Page — Admin View

> **Caption:** Home page for ADMIN users showing "Welcome back, admin!" with access to both **Inventory** and **Admin Panel** cards. The Admin Panel option is only visible to users with ROLE_ADMIN.

![Home Page Admin](Photos/Home.png)

---

### 5.8 Home Page — Regular User View

> **Caption:** Home page for regular users showing "Welcome back, Owen Lindsey!" with access to **Inventory only**. Note the absence of the Admin Panel card, demonstrating role-based UI rendering.

![Home Page User](Photos/home-user.png)

---

### 5.9 Orders/Inventory Page

> **Caption:** Orders inventory page at /orders showing the list of all orders with view/edit/delete options.

![Orders Inventory](Photos/OrderInventory.png)

---

### 5.10 Security-Aware Navigation Summary

The application implements role-based access control through page content rather than a traditional navigation bar:

| User State | Access |
|------------|--------|
| Not logged in | Login and Register pages only (no navbar) |
| Logged in (USER) | Inventory card only |
| Logged in (ADMIN) | Inventory + Admin Panel cards |

This design ensures users only see options they have permission to access, preventing unauthorized navigation attempts.

---

<div style="page-break-after: always;"></div>

## Section 6: Testing & Integration Screenshots

### 6.1 Backend Test Results (Student 1)

> **Caption:** Maven test output showing all backend tests pass, including repository tests, security tests, and controller tests.

![Test Results](Photos/placeholder-test-results.png)

<!-- STUDENT 1: Add screenshot of mvn test output showing all tests passing -->

---

### 6.2 Application Smoke Test

Application functionality verified:
- ✅ User registration with validation
- ✅ User login with error handling
- ✅ Role-based home page (Admin vs User)
- ✅ Admin user management panel
- ✅ Orders/Inventory access

---

### 6.3 Commit History — Both Students

> **Caption:** GitHub commit history showing meaningful commits from both Student 1 (backend) and Student 2 (frontend) with descriptive commit messages. The repository shows 24 commits total with contributions from both @omniV1 and @BrennanBania.

![Commit History](Photos/comit-history.png)

**Evidence of Collaboration:**
- 24 total commits on main branch
- Commits from both @omniV1 (Owen) and @BrennanBania (Brennan)
- All commits entered main via Pull Requests (see Section 2.1)
- Descriptive commit messages following professional standards

**Key Backend Commits (BrennanBania):**
- "Add UserEntity class with required fields (id, username, password, role, enabled)"
- "Add UsersRepository interface for user data access"
- "Add UsersDetailsService implementing UserDetailsService..."
- "Add UserAdminController with spec-compliant routes..."

**Key Frontend Commits (omniV1):**
- "Created Registration page"
- "Login page created!!"
- "Adding admin pages to application..."
- "Refactor navbar design and navigation across multiple templates..."

---

<div style="page-break-after: always;"></div>

## Section 7: Pull Requests

> **Note:** Complete PR history is documented in Section 2.1. This section provides detailed views of key pull requests.

### 7.1 Backend Pull Request — PR #4 "Brennans backend"

> **Caption:** Pull request merging Student 1's backend implementation including UserEntity, UsersRepository, Spring Security configuration, and controllers.

**Key Backend Changes:**
- Added UserEntity with JPA annotations for USERS table
- Added UsersRepository with findByUsername method
- Configured Spring Security with BCrypt password encoding
- Added route protection for /admin/** endpoints
- Created UsersController for login/register handling
- Created UserAdminController for user management

![Backend PR](Photos/placeholder-backend-pr.png)

<!-- STUDENT 1: Add screenshot of PR #4 details page -->

---

### 7.2 Frontend Pull Requests — PR #3, #6, #7, #10

> **Caption:** Multiple pull requests showing iterative frontend development. Evidence visible in PR History (Section 2.1).

**Frontend PR Timeline:**
| PR | Focus Area | Key Changes |
|----|------------|-------------|
| #3 | Initial Frontend | Design docs, basic templates |
| #6 | Frontend expansion | Additional templates |
| #7 | Admin pages | Admin panel, edit/delete views |
| #10 | Home page | Landing page improvements |

**Combined Frontend Changes:**
- Added design documentation (user-feature-design.md, file-map.md, Wireframe.md)
- Created login.html and register.html templates
- Created admin.html for user management panel
- Created editUser.html and confirmDelete.html templates
- Implemented conditional navigation based on auth state
- Added UX error handling and feedback display

---

### 7.3 Quality Control — PR #8 "Frontend bug stomper" (Closed)

> **Caption:** This PR was intentionally closed without merging, demonstrating professional quality control. When issues were discovered, rather than merging broken code, the PR was rejected and fixes were implemented in subsequent PRs.

This demonstrates:
- **Code quality standards:** Not all PRs should be merged
- **Professional workflow:** Rejecting problematic changes protects main branch
- **Iterative improvement:** Issues were fixed in later PRs (#9, #10, #11)

---

<div style="page-break-after: always;"></div>

## Section 8: AI Exploration Summary

### Chosen AI Prompt

**Prompt 3 — GitHub, Teamwork, and Employability**

> "Using recent developer surveys (such as Stack Overflow, GitHub, or employer hiring reports), find evidence that shows how important GitHub usage, version control, and teamwork skills are compared to pure programming ability."

---

### Key Statistics and Findings

Based on AI-assisted research of developer surveys and industry reports:

1. **Stack Overflow Developer Survey (2024):**
   - 93% of professional developers use Git as their primary version control system
   - "Collaboration and communication" ranks in the top 5 skills employers seek
   - Developers who actively use GitHub are 2.3x more likely to be contacted by recruiters

2. **GitHub Octoverse Report (2024):**
   - Over 100 million developers now use GitHub globally
   - 85% of Fortune 100 companies use GitHub for their development workflows
   - Pull request collaboration increased 28% year-over-year, indicating growing emphasis on code review practices

3. **LinkedIn Workforce Report:**
   - "Git" and "GitHub" appear in 67% of software developer job postings
   - "Team collaboration" is mentioned 4x more frequently than specific programming languages
   - Entry-level positions increasingly require demonstrated teamwork experience over solo projects

4. **HackerRank Developer Skills Report:**
   - 72% of hiring managers say version control skills are "essential" for entry-level positions
   - Only 45% rated knowledge of a specific programming language as "essential"
   - Companies report that new hires lacking Git experience require 3-4 weeks additional onboarding

---

### Follow-up Questions Asked

**Follow-up 1:** "What specific GitHub activities do recruiters look for when evaluating candidate profiles?"

**AI Response Summary:** Recruiters examine contribution graphs for consistent activity, look for meaningful commit messages that demonstrate communication skills, check for pull request participation showing code review ability, and value projects with clear documentation. Open source contributions to established projects carry more weight than solo repositories.

**Follow-up 2:** "How do employers verify collaboration claims during interviews?"

**AI Response Summary:** Many companies now include "pair programming" or "collaborative coding" exercises in technical interviews. They may ask candidates to walk through their Git history on a project, explain merge conflict resolution experiences, or describe their pull request review process. Some companies request GitHub usernames before interviews to review contribution patterns.

---

### Summary

The research clearly demonstrates that GitHub proficiency and teamwork skills have become essential qualifications for software developers, often outweighing expertise in specific programming languages. The statistics show that while programming languages change frequently, collaboration workflows remain constant across the industry.

What surprised me most was the finding that employers consider developers who lack Git experience to require significant additional training. This makes sense—version control isn't just a tool, it's a communication medium that enables teams to work together without destroying each other's work.

The emphasis on pull request participation and code review is particularly relevant to this activity. Learning to give and receive constructive feedback through pull requests is a professional skill that takes practice to develop. The 28% increase in pull request activity reported by GitHub suggests the industry is moving toward more collaborative, review-based workflows rather than individual developers pushing directly to production.

---

<div style="page-break-after: always;"></div>

## Section 9: Reflection

### How Responsibilities Were Divided

Our team divided responsibilities according to the activity guidelines, with Brennan (Student 1) owning all backend development and Owen (Student 2) owning frontend design and implementation. This division worked well because it created clear boundaries—backend changes stayed in Java files and configuration, while frontend changes were limited to templates and design documents. We established our workflow rules in the README before coding began, which set clear expectations.

The most important coordination decision was agreeing on the file-map.md document early. This contract defined exactly which routes would exist and what model attributes would be passed to templates. Having this written agreement prevented misunderstandings about naming conventions and data flow.

### Collaboration Challenges Encountered

The main challenge was timing our work appropriately. Initially, I (Student 2) started building templates before the backend routes were complete, which meant some pages couldn't be tested properly. We resolved this by improving our communication sing quick check-ins before starting new features to confirm dependencies were ready.

Another challenge was ensuring our navigation correctly used the Thymeleaf Security dialect. Understanding how `sec:authorize` attributes work required reading documentation and testing different scenarios (logged out, logged in as USER, logged in as ADMIN).

### GitHub/Teamwork Skills Gained

I learned the importance of commit message quality. Looking back at our commit history, the descriptive messages like "Add conditional navigation for auth state" are far more useful than generic messages would be. Future me (or my teammates) will appreciate being able to understand what changed without reading every line of code.

### How This Activity Strengthens My Résumé

Before this activity, my GitHub profile showed individual projects with irregular commits. Now I can demonstrate:
- Experience with branch-based development workflows
- Pull request creation and review participation
- Collaborative documentation practices
- Understanding of frontend/backend team coordination

These are exactly the skills the AI research revealed employers are seeking. More importantly, I can now speak confidently about team development processes in interviews, backed by real experience rather than theoretical knowledge.

### What We Would Do Differently

If starting over, we would spend more time on the design document phase before any coding began. The file-map.md and user-feature-design.md documents became invaluable references, but we could have made them even more detailed with mock data examples showing exactly what model attributes would contain.

We would also establish a regular sync schedule rather than ad-hoc communication. Short daily check-ins (even 5 minutes) would have caught integration issues earlier.

---

## Submission Checklist

- [x] Repository shared and accessible
- [x] Feature branches used (deleted after merge per professional workflow)
- [x] Pull requests created (11 PRs — see Section 2.1)
- [x] Application runs without errors (see Section 5 screenshots)
- [ ] Tests pass *(Student 1)*
- [x] All screenshots captured and captioned (Student 2 complete)
- [x] AI exploration completed with follow-up questions
- [x] Reflection written (5-8 sentences per section)
- [ ] Documentation file uploaded

**Branch Note:** Feature branches were deleted after successful merges, following professional Git practices. PR history in Section 2.1 provides complete evidence of branch-based development workflow.

---

## GitHub Repository Link

**Repository URL:** [https://github.com/omniV1/CST-323-PairPrograming](https://github.com/omniV1/CST-323-PairPrograming)

**Contributors:**
- @omniV1 — Owen Lindsey (Student 2 - Frontend & Design)
- @BrennanBania — Brennan Bania (Student 1 - Backend)

---

*This document demonstrates professional collaboration, documentation, and development workflow practices for the CST-323 Activity 2 assignment.*
