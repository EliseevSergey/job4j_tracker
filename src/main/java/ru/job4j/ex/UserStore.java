package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUserName().equals(login)) {
                rsl = users[index];
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("Nothing was found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUserName().length() < 3) {
            throw new UserInvalidException("Invalid user");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Bro", true)
        };
        try {
            validate(findUser(users, "Bro"));
        } catch (UserInvalidException invalid) {
            System.out.println("User is not valid");
        } catch (UserNotFoundException notFound) {
            System.out.println("User is not found");
         }
    }
}

