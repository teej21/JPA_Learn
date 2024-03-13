# User APIs

## Add New User

- **Endpoint**: `/intern-vnpt/add`
- **Method**: POST
- **Parameters**:
    - `name`: String (required)
    - `email`: String (required)
- example: `/intern-vnpt/add?name=Nguyen+Van+A&email=nguyenvana%40gmail.com`

## Delete User

- **Endpoint**: `/intern-vnpt/delete`
- **Method**: DELETE
- **Parameters**:
    - `id`: Integer (required)
- example: `/intern-vnpt/delete?id=1`

## Update User

- **Endpoint**: `/intern-vnpt/update`
- **Method**: PUT
- **Parameters**:
    - `id`: Integer (required)
    - `name`: String (required)
    - `email`: String (required)
- example: `/intern-vnpt/update?id=1&name=Nguyen+Van+A&email=nguyenvana%40gmail.com`

## Find User

- **Endpoint**: `/intern-vnpt/find`
- **Method**: GET
- **Parameters**:
    - `id`: Integer (required)
- example: `/intern-vnpt/find?id=1`

## Get All Users

- **Endpoint**: `/intern-vnpt/all`
- **Method**: GET
- **Parameters**:
    - `sort`: String (optional, defaults to "name", can be "email" for sorting by email)
- example: `/intern-vnpt/all?sort=email`
