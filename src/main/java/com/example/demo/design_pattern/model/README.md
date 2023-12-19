## Builder Pattern
Joshua Bloch, in his book "[Effective Java](https://kea.nu/files/textbooks/new/Effective%20Java%20%282017%2C%20Addison-Wesley%29.pdf)", introduced an improved version of the builder pattern 
which is clean, highly readable (because it makes use of fluent design) and easy to use from client's perspective.

This example *User* class contains a builder as a ***static*** inner class:
```
public class User {
    // All the access modifiers on the fields are declared private since we don't want outer objects to access them directly.
    // They can be accessed through setter/getter.
    private String username;
    private String password;

    // The constructor is also private so that only the Builder assigned to this class can access it.
    // All of the properties set in the constructor are extracted from the builder object which we supply as an argument.
    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder {
        // We've declared the same set of fields that the outer class contains.
        private String username;
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        // The build method calls the private constructor of the outer class and passes itself as the argument.
        public User build() {
            return new User(this);
        }
    }
}
```
The returned *User* will be instantiated with the parameters set by the *Builder*.
```
User user = new User.Builder()
                .username("Anna")
                .password("123456")
                .build();
```

### When to use Builder Pattern
1. When the object creation process is complex and involves multiple mandatory and optional parameters.
2. When the number of constructor parameters becomes large, resulting in a long list of constructors.
3. When the client expects different representations of the constructed object.