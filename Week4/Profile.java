class Profile {
    private String name;
    private int age;
    private double heightMetres;

    public Profile(String name, int age, double heightMetres) {

        if (name == null || name.isBlank()) {
            System.out.println("Error: Name cannot be blank.");
            return;
        }

        if (age < 0) {
            System.out.println("Error: Age cannot be negative.");
            return;
        }

        if (heightMetres <= 0) {
            System.out.println("Error: Height must be positive.");
            return;
        }

        this.name = name;
        this.age = age;
        this.heightMetres = heightMetres;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeightMetres() {
        return heightMetres;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heightMetres=" + heightMetres +
                '}';
    }
}
