
public class Twitter {
    Map<Integer,Set<Integer>> followersMap = new HashMap<>();
    Map<Integer,List<Twit>> tweetsMap = new HashMap<>();
    int tweetCounter = 0;

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        List<Twit> tweets = tweetsMap.computeIfAbsent(userId, integer -> new LinkedList<>());
        tweets.addFirst(new Twit(tweetCounter++, tweetId));
        if (tweets.size() > 10)
            tweets.removeLast();
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Twit> ownTweets = tweetsMap.getOrDefault(userId, new LinkedList<>());
        PriorityQueue<Twit> feed = new PriorityQueue<>(
                Comparator.comparingInt((Twit t) -> t.tweetNo)/*.reversed()*/);
        feed.addAll(ownTweets);
        
        Set<Integer> users = followersMap.getOrDefault(userId, new HashSet<>());
        
        for (Integer user : users) {
            List<Twit> twits = tweetsMap.getOrDefault(user, new LinkedList<>());
            for (Twit twit : twits) {
                if (feed.isEmpty() || feed.size() < 10)
                    feed.offer(twit);
                else if (feed.peek().tweetNo > twit.tweetNo)
                    break;
                else {
                    feed.offer(twit);
                    if (feed.size() > 10)
                        feed.remove();
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!feed.isEmpty()) {
            result.addFirst(feed.poll().tweetId);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            Set<Integer> followers = followersMap.computeIfAbsent(followerId, k -> new HashSet<>());
            followers.add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId)) {
            followersMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }

    public class Twit {
        public int tweetNo;
        public int tweetId;

        public Twit(int tweetNo, int tweetId) {
            this.tweetNo = tweetNo;
            this.tweetId = tweetId;
        }
    }
}