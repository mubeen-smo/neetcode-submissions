
class Twitter {
    private class Tweet {
        int count;
        int id;
        Tweet(int count, int id) {
            this.count = count;
            this.id = id;
        }
        private int getCount() {
            return this.count;
        }
        private int getId() {
            return this.id;
        }
    }
    
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int count;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweetMap.getOrDefault(userId, null) == null) {
            tweetMap.put(userId, new ArrayList<>());
        }
        Tweet tweet = new Tweet(count++, tweetId);
        tweetMap.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> allUsers = new HashSet<>(followMap.getOrDefault(userId, new HashSet<>()));
        allUsers.add(userId);

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getCount(), a.getCount()));
        List<Integer> res = new ArrayList<>();

        for (int id : allUsers) {
            List<Tweet> tweets = tweetMap.getOrDefault(id, null);
            if (tweets != null) {
                maxHeap.addAll(tweets);
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll().getId());
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (followMap.getOrDefault(followerId, null) == null) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId)  {
        if (followerId == followeeId) return;
        if (followMap.getOrDefault(followerId, null) == null) return;
        followMap.get(followerId).remove(followeeId);
    }
}
