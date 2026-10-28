class Twitter {

    // Represents one tweet in a user's timeline
    private static class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time, Tweet next) {
            this.tweetId = tweetId;
            this.time = time;
            this.next = next;
        }
    }

    // Each user points to their newest tweet
    private Map<Integer, Tweet> tweets;

    // followerId -> set of users they follow
    private Map<Integer, Set<Integer>> following;

    // Global timestamp to order all tweets
    private int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {

        // Link the new tweet to the previous newest tweet
        Tweet previous = tweets.get(userId);

        Tweet newTweet = new Tweet(
            tweetId,
            timestamp++,
            previous
        );

        // Update the user's newest tweet
        tweets.put(userId, newTweet);
    }



    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();

        // Max Heap: newest timestamp comes first
        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(b.time, a.time)
            );

        // Include the user's own tweets
        if (tweets.containsKey(userId)) {
            maxHeap.offer(tweets.get(userId));
        }

        // Include the newest tweet from each followed user
        Set<Integer> users = following.getOrDefault(
            userId, Collections.emptySet()
        );

        for (int followeeId : users) {
            Tweet head = tweets.get(followeeId);

            if (head != null) {
                maxHeap.offer(head);
            }
        }

        // Extract at most 10 newest tweets
        while (!maxHeap.isEmpty() && feed.size() < 10) {

            Tweet newest = maxHeap.poll();
            feed.add(newest.tweetId);

            // Add the next older tweet from the same timeline
            if (newest.next != null) {
                maxHeap.offer(newest.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following
            .computeIfAbsent(
                followerId, id -> new HashSet<>()
            )
            .add(followeeId);
    }
    

    public void unfollow(int followerId, int followeeId) {

        Set<Integer> users = following.get(followerId);

        if (users != null) {
            users.remove(followeeId);
        }
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */