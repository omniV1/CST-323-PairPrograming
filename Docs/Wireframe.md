# Wireframes

## Orders4U Application

---

|                |                              |
| -------------- | ---------------------------- |
| **Authors**    | Owen Lindsey & Brennan Bania |
| **Course**     | CST-323                      |
| **Instructor** | Professor Sluiter            |
| **Date**       | 23 January 2026              |

---

## Document Purpose

This document contains wireframe specifications for each page in the Orders4U application. Wireframes define layout structure, form fields, buttons, and expected behavior for frontend implementation.

---

## Table of Contents

- [[#Site Map Overview]]
- [[#1. login.html]]
- [[#2. register.html]]
- [[#3. admin.html]]
- [[#4. editUser.html]]
- [[#5. confirmDelete.html]]
- [[#Role-Based Navigation]]

<div style="page-break-after: always;"></div>

---

## Site Map Overview

![[CST-323PairProgramming-Design.png]]

<div style="page-break-after: always;"></div>

---

## 1. login.html

Centered login form with "Login" title. Displays error messages below the form when authentication fails.

| Field    | Type     | Validation |
| -------- | -------- | ---------- |
| Username | Text     | Required   |
| Password | Password | Required   |

| Button   | Action                            |
| -------- | --------------------------------- |
| Submit   | Authenticate user credentials     |
| Register | Link to register.html             |



---

## 2. register.html

Centered registration form with "Register" title. Validates password match and displays inline errors.

| Field            | Type     | Validation                    |
| ---------------- | -------- | ----------------------------- |
| Username         | Text     | Required, alphanumeric        |
| Password         | Password | Required, 8+ characters       |
| Confirm Password | Password | Required, must match password |

| Button | Action                |
| ------ | --------------------- |
| Submit | Create new account    |
| Login  | Link to login.html    |



---

## 3. admin.html

Admin panel displaying all users in a list/grid format. Each row shows avatar, username, role, and status with action buttons.

| Button | Location     | Action                      |
| ------ | ------------ | --------------------------- |
| Edit   | Per user row | Navigate to editUser.html   |
| Delete | Per user row | Navigate to confirmDelete.html |
| Status | Per user row | Toggle enabled/disabled     |

<div style="page-break-after: always;"></div>

---

## 4. editUser.html

Edit form for modifying user details. Header displays user avatar and username.

| Field    | Type     | Validation        |
| -------- | -------- | ----------------- |
| Username | Text     | Required          |
| Password | Password | Optional          |
| Role     | Dropdown | Admin / User      |
| Status   | Checkbox | Enabled/Disabled  |

| Button | Action                              |
| ------ | ----------------------------------- |
| Update | Save changes, return to admin panel |
| Delete | Navigate to confirmDelete.html      |



---

## 5. confirmDelete.html

Delete confirmation dialog displaying user info and warning message.

| Button  | Action                            |
| ------- | --------------------------------- |
| Confirm | Delete user, return to admin list |
| Cancel  | Return to admin list              |

Warning displayed: "This action cannot be undone"


---

## Role-Based Navigation

| User Role | Post-Login Redirect |
| --------- | ------------------- |
| Admin     | Home (with Admin Panel access) |
| User      | Home (Inventory only) |
