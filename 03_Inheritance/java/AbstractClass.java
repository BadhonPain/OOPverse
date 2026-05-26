public class AbstractClass {

    // Abstract class - cannot be instantiated directly
    static abstract class Employee {
        protected String name;
        protected int id;
        private static int nextId = 1;

        Employee(String name) {
            this.name = name;
            this.id = nextId++;
        }

        // Abstract methods - must be implemented by subclasses
        abstract double calculatePay();
        abstract String getRole();

        // Concrete methods - shared by all subclasses
        void displayPaySlip() {
            System.out.printf("#%d %-15s [%-12s] Pay: $%,.2f%n",
                    id, name, getRole(), calculatePay());
        }

        // Template method pattern
        final void processPayroll() {
            System.out.println("Processing payroll for " + name + "...");
            double pay = calculatePay();
            double tax = pay * 0.2;
            double net = pay - tax;
            System.out.printf("  Gross: $%,.2f | Tax: $%,.2f | Net: $%,.2f%n", pay, tax, net);
        }

        @Override
        public String toString() {
            return String.format("%s{id=%d, name='%s'}", getRole(), id, name);
        }
    }

    static class FullTimeEmployee extends Employee {
        private double annualSalary;

        FullTimeEmployee(String name, double annualSalary) {
            super(name);
            this.annualSalary = annualSalary;
        }

        @Override
        double calculatePay() {
            return annualSalary / 12.0;
        }

        @Override
        String getRole() { return "Full-Time"; }
    }

    static class PartTimeEmployee extends Employee {
        private double hourlyRate;
        private int hoursWorked;

        PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
            super(name);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        double calculatePay() {
            return hourlyRate * hoursWorked;
        }

        @Override
        String getRole() { return "Part-Time"; }
    }

    static class Contractor extends Employee {
        private double projectFee;

        Contractor(String name, double projectFee) {
            super(name);
            this.projectFee = projectFee;
        }

        @Override
        double calculatePay() {
            return projectFee;
        }

        @Override
        String getRole() { return "Contractor"; }
    }

    // Abstract class with some abstract and some concrete methods
    static abstract class Shape {
        protected String color;

        Shape(String color) { this.color = color; }

        abstract double area();
        abstract double perimeter();

        // Concrete method using abstract methods
        void describe() {
            System.out.printf("%s %s: area=%.2f, perimeter=%.2f%n",
                    color, getClass().getSimpleName(), area(), perimeter());
        }
    }

    static class CircleShape extends Shape {
        private double radius;

        CircleShape(String color, double radius) {
            super(color);
            this.radius = radius;
        }

        @Override
        double area() { return Math.PI * radius * radius; }

        @Override
        double perimeter() { return 2 * Math.PI * radius; }
    }

    static class RectShape extends Shape {
        private double w, h;

        RectShape(String color, double w, double h) {
            super(color);
            this.w = w;
            this.h = h;
        }

        @Override
        double area() { return w * h; }

        @Override
        double perimeter() { return 2 * (w + h); }
    }

    public static void main(String[] args) {
        // Cannot instantiate abstract class
        // Employee e = new Employee("test"); // COMPILE ERROR

        System.out.println("=== Employee Payroll ===");
        Employee[] staff = {
            new FullTimeEmployee("Alice", 96000),
            new PartTimeEmployee("Bob", 25, 80),
            new Contractor("Charlie", 5000),
            new FullTimeEmployee("Diana", 120000),
            new PartTimeEmployee("Eve", 30, 60)
        };

        for (Employee e : staff) {
            e.displayPaySlip();
        }

        // Template method pattern (final method using abstract methods)
        System.out.println("\n=== Template Method (processPayroll) ===");
        staff[0].processPayroll();
        staff[1].processPayroll();
        staff[2].processPayroll();

        // Total payroll
        System.out.println("\n=== Total Monthly Payroll ===");
        double total = 0;
        for (Employee e : staff) {
            total += e.calculatePay();
        }
        System.out.printf("Total: $%,.2f%n", total);

        // Shape hierarchy
        System.out.println("\n=== Abstract Shape Hierarchy ===");
        Shape[] shapes = {
            new CircleShape("Red", 5),
            new RectShape("Blue", 4, 6),
            new CircleShape("Green", 3)
        };

        for (Shape s : shapes) {
            s.describe();
        }

        // Polymorphic reference
        System.out.println("\n=== Polymorphic toString ===");
        for (Employee e : staff) {
            System.out.println(e);
        }
    }
}
