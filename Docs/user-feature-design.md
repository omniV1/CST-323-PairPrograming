### Owen Lindsey & Brennan Bania
### Professor Sluiter
### CST-323
### Date (ddmmyy)

---

# User Feature Design

## What Problem Does This Feature Solve?

This feature provides secure user authentication and administrative user management for the application. It allows new users to register accounts, existing users to log in and access their data, and administrators to manage all user accounts in the system.

---

## Feature Summary

### Registration
- New users can create an account by providing a username and password
- Password confirmation ensures accuracy during signup
- Credentials are securely stored in the SQL database
- After successful registration, users are redirected to their inventory page

### Login / Logout
- Existing users authenticate with username and password
- Invalid credentials display an error message prompting correction
- Successful login redirects users based on their role
- Users can securely log out to end their session

### Admin User Management
- Administrators have a dedicated panel to view all users
- Admins can view detailed user profiles
- Admins can edit user information (username, role, status)
- Admins can delete user accounts with confirmation

---

## User Roles

### Regular User
- Can register a new account
- Can log in and log out
- Can access their personal inventory page
- Can view and manage their orders

### Admin
- Has all Regular User capabilities
- Can access the Admin Panel
- Can view a list of all users in the system
- Can view detailed user profiles
- Can edit user information (username, role, status)
- Can delete user accounts

---

## High-Level User Flows

### Regular User Flow
```
Register → Login → Inventory Page → Manage Orders
```

### Admin User Flow
```
Login → Admin Panel → View Users → Select User → Edit / Delete
```

### Detailed Flows

**Registration Flow:**
1. User navigates to Register page
2. User enters username and password (with confirmation)
3. System validates input constraints
4. On success: Account created, redirect to Inventory
5. On failure: Display error, prompt correction

**Login Flow:**
1. User navigates to Login page
2. User enters username and password
3. System validates credentials
4. On success: Redirect based on role (Admin → Admin Panel, User → Inventory)
5. On failure: Display "User not found" error

**Admin Edit User Flow:**
1. Admin logs in → Admin Panel
2. Admin selects user from list
3. Admin views user details
4. Admin clicks Edit → Edit User page
5. Admin modifies fields (username, role, status)
6. Admin saves changes → Return to user list

**Admin Delete User Flow:**
1. Admin logs in → Admin Panel
2. Admin selects user from list
3. Admin clicks Delete → Confirm Delete page
4. Admin confirms deletion (with warning displayed)
5. User is deleted → Return to user list

---

## Site Map

![[CST-323PairProgramming-Design.png]]

