### Owen Lindsey & Brennan Bania
### Professor Sluiter
### CST-323
### Date (ddmmyy)

---

# Wireframes

## Site Map Overview

![[CST-323PairProgramming-Design.png]]

---

## 1. login.html

### Title
- "Login" - centered at top of page

### Main Sections
- Header with page title
- Login form (centered)
- Navigation link to registration

### Forms
| Field    | Type     | Validation                    |
|----------|----------|-------------------------------|
| Username | Text     | Required                      |
| Password | Password | Required                      |

### Buttons
| Button   | Action                                          |
|----------|-------------------------------------------------|
| Submit   | Authenticate user credentials                   |
| Register | Navigate to register.html (link below form)     |

### Error/Message Areas
- Error message displayed below form: "User not found. Verify username or password."
- Field-level validation errors displayed inline

---

## 2. register.html

### Title
- "Register" - centered at top of page

### Main Sections
- Header with page title
- Registration form (centered)
- Navigation link to login

### Forms
| Field            | Type     | Validation                              |
|------------------|----------|-----------------------------------------|
| Username         | Text     | Required, alphanumeric, length limits   |
| Password         | Password | Required, 8-25 characters               |
| Confirm Password | Password | Required, must match Password field     |

### Buttons
| Button | Action                                      |
|--------|---------------------------------------------|
| Submit | Create new user account                     |
| Login  | Navigate to login.html (link below form)    |

### Error/Message Areas
- Password mismatch error: "Passwords do not match"
- Username constraint error: "Username must be alphanumeric"
- Length constraint error: "Password must be 8-25 characters"
- Success message on redirect

---

## 3. userAdmin.html

### Title
- "Admin Panel" - displayed in header

### Main Sections
- Header with title and admin info
- "Users" section header
- User list table/grid
- Each user row displays: Avatar, Username, Role, Status

### Forms
- No forms on this page (display only)

### Buttons
| Button | Location      | Action                              |
|--------|---------------|-------------------------------------|
| Edit   | Per user row  | Navigate to editUser.html           |
| Delete | Per user row  | Navigate to confirmDeleteUser.html  |

### Error/Message Areas
- Success message after user edit: "User updated successfully"
- Success message after user delete: "User deleted successfully"
- Empty state message if no users exist

---

## 4. editUser.html

### Title
- "User1" (or username) - displayed in header with user avatar

### Main Sections
- Header with user avatar and username
- User profile details section
- Edit form fields
- Action buttons

### Forms
| Field    | Type     | Validation         |
|----------|----------|--------------------|
| Username | Text     | Required           |
| Role     | Dropdown | Admin / User       |
| Status   | Dropdown | Active / Inactive  |

### Buttons
| Button         | Action                                    |
|----------------|-------------------------------------------|
| Change Username| Apply username change                     |
| Change Role    | Apply role change                         |
| Change Status  | Apply status change                       |
| Save / Back    | Save all changes and return to admin list |

### Error/Message Areas
- Validation errors displayed inline
- Success message: "Changes saved successfully"
- Error message: "Failed to update user"

---

## 5. confirmDeleteUser.html

### Title
- "User1" (or username) - displayed in header with user avatar

### Main Sections
- Header with user avatar and username
- User profile summary
- Delete confirmation dialog box

### Forms
- No editable form fields (confirmation only)

### Buttons
| Button  | Action                                      |
|---------|---------------------------------------------|
| Confirm | Delete user and return to admin list        |
| Cancel  | Return to admin list without deleting       |

### Error/Message Areas
- **Warning message (prominent):** "Delete this user?"
- **Destructive action warning:** "WARNING: This action cannot be undone"
- Error message if deletion fails: "Failed to delete user"

---

## Role-Based Navigation

| User Role | After Login Redirect |
|-----------|---------------------|
| Admin     | userAdmin.html      |
| User      | Inventory page      |

