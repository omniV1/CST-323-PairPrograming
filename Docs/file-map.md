### Owen Lindsey & Brennan Bania
### Professor Sluiter
### CST-323
### Date (ddmmyy)

---

# File Map

This document maps backend routes to frontend templates. This serves as the contract between Student 1 (Backend) and Student 2 (Frontend).

**Rule:** If a page does not appear in this file-map, it should not be implemented.

---

## Route to Template Mapping

| HTTP Method | Route                  | Template               | Description                    |
|-------------|------------------------|------------------------|--------------------------------|
| GET         | /login                 | login.html             | Display login form             |
| POST        | /login                 | login.html             | Process login credentials      |
| GET         | /register              | register.html          | Display registration form      |
| POST        | /register              | register.html          | Process new user registration  |
| GET         | /admin/users           | userAdmin.html         | Display list of all users      |
| GET         | /admin/users/{id}/edit | editUser.html          | Display edit form for user     |
| POST        | /admin/users/{id}/edit | editUser.html          | Process user updates           |
| GET         | /admin/users/{id}/delete | confirmDeleteUser.html | Display delete confirmation  |
| POST        | /admin/users/{id}/delete | confirmDeleteUser.html | Process user deletion        |
| POST        | /logout                | (redirect to login)    | End user session               |

---

## Template Summary

| Template               | Purpose                                      |
|------------------------|----------------------------------------------|
| login.html             | User authentication                          |
| register.html          | New user account creation                    |
| userAdmin.html         | Admin panel - view all users                 |
| editUser.html          | Admin - edit user details                    |
| confirmDeleteUser.html | Admin - confirm user deletion with warning   |

---

## Notes

- All admin routes (`/admin/*`) require admin role authentication
- POST routes process form submissions and may redirect or re-render with errors
- Error messages should be displayed on the same template that initiated the action
