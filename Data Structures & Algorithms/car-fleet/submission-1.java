class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 0;
        int length = position.length;
        if (length == 1)
            return 1;

        Car[] cars = new Car[length];
        for (int i = 0; i < length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, Comparator.comparingInt(o -> o.position));
        Stack<Double> cyclesStack = new Stack<>();
        for (int i = length - 1; i >= 0 ; i--) {
            Car car = cars[i];
            double cycles = (double) (target - car.position) / car.speed;
            while (!cyclesStack.isEmpty() && cycles > cyclesStack.peek()) {
                cyclesStack.pop();
            }
            if (cyclesStack.isEmpty())
                fleets++;

            cyclesStack.add(cycles);
        }
        return fleets;
    }

    public static class Car {
        public int position;
        public int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
