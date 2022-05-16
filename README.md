# Spring Boot User Feature Access Management

## User story:
As Product Manager, I would like to manage users’ accesses to new features via feature switches, i.e. enabling/disabling certain feature based on a user’s email and feature names).

## Requirements:

- `GET /feature?email=XXX&featureName=XXX`
> This endpoint receives email (user’s email) and featureName as request parameters and returns the following response in JSON format.

*Example Response*
```
{
    "canAccess": true|false (will be true if the user has access to the featureName
}
```

- `POST /feature`
> This endpoint receives the following request in JSON format and returns an empty response with HTTP Status OK (200) when the database is updated successfully, otherwise returns Http Status Not Modiﬁed (304).

*Example Response*
```
{
    "featureName": "xxx", (string)
    "email": "xxx", (string) (user's name)
    "enable": true|false (boolean) (uses true to enable a user's access, otherwise
}
```

### Note
- Requires MySQL Workbench setup on local machine, with a schema created as follows;
```
schema name: feature_access_db
user: test
password: 1234
```
- If it's desired to customise these settings, edit the file at `src/main/resources/application.properties`
- The Spring Initializr was used (https://start.spring.io/).
- For easy testing, use Postman.
