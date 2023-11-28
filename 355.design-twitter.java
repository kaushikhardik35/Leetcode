/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {

    class Tweet{
        int userId;
        int tweetId;
        public Tweet(int userId, int tweetId){
            this.userId=userId;
            this.tweetId=tweetId;
        }
    }

    HashMap<Integer,Set<Integer>> followings;
    List<Tweet> tweets;

    public Twitter() { 
        followings=new HashMap<>();
        tweets=new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int n=tweets.size();
        List<Integer> newsFeed=new ArrayList<>();
        Set<Integer> follows=followings.get(userId);
        for(int i=n-1;i>=0;i--){
            if(newsFeed.size()>9) return newsFeed;
            Tweet t=tweets.get(i);
            if(t.userId==userId||(follows!=null&&follows.contains(t.userId))){
                newsFeed.add(t.tweetId);
            }
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followings.containsKey(followerId)){
            followings.get(followerId).add(followeeId);
        }
        else{
            Set<Integer> set=new HashSet<>();
            set.add(followeeId);
            followings.put(followerId,set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followings.get(followerId)!=null&&followings.get(followerId).contains(followeeId)){
            followings.get(followerId).remove(followeeId);
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
// @lc code=end

