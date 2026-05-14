class TimeMap {
    Map<String, List<Node>> usersMap;

    public TimeMap() {
        usersMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        usersMap.putIfAbsent(key,new ArrayList<>());
        usersMap.get(key).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String result = "";
        if (usersMap.containsKey(key)) {
            var statuses = usersMap.get(key);
            int l = 0;
            int r = statuses.size()-1;
            while (l <= r) {
                int mid = (l + r)/2;
                Node node = statuses.get(mid);
                if (timestamp >= node.time) {
                    result = node.status;
                    if (timestamp == node.time)
                        break;
                    l = ++mid;
                } else {
                    r = --mid;
                }
            }
        }
        return result;

    }
    public static class Node {
        public int time;
        public String status;

        public Node(int time, String status) {
            this.time = time;
            this.status = status;
        }
    }
}