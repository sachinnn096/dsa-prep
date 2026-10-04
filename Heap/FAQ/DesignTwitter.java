package Heap.FAQ;
import java.util.*;

class DesignTwitter {

    //tweet class
    class Tweet{

        private int tweet_id;
        public Tweet next;
        public int seq ;

        public Tweet( int t,int s){
            this.tweet_id = t;
            this.next = null;
            this.seq = s;
        }

        //getter method
        public int getTweet_id(){
            return this.tweet_id;
        }

    }


    Map< Integer , Set<Integer> > userDetails;  //store USER| [ FOLLOWING LIST ]
    Map<Integer,Tweet> tweets;                   // stoer USER | [ LATEST TWEET BY USER ]
    int seq;

    //intializing the data structure
    public DesignTwitter() {
        userDetails = new HashMap<>();
        tweets = new HashMap<>();
        this.seq = 0;
    }


    //user twitted -> add it to all tweets
    public void postTweet(int userId, int tweetId) {

        seq++;
        // new user ->  add data to user table
        if( !userDetails.containsKey( userId ) ){
            userDetails.put( userId, new HashSet<>() );
        }
        // user have not tweeted before -> first tweet

        //new tweet
        Tweet t = new Tweet( tweetId,seq );
        t.next = tweets.get( userId );

        tweets.put( userId, t );

        //adding the tweet
    }

    public List<Integer> getNewsFeed(int userId) {


        List<Integer> personalizedNewsFeed = new ArrayList<>();

        // this is a new user ,,, means no following & no tweets done by him
        if( !userDetails.containsKey( userId ) ){
            return personalizedNewsFeed;
        }

        // fetching the following list of user
        Set<Integer> followings = userDetails.get( userId );

        //always give the most recent posted tweet
        PriorityQueue<Tweet> maxheap = new PriorityQueue<>( (a,b)->Integer.compare( b.seq , a.seq ) );

        // if user(himself) have tweeted before ,,, add most recent tweet
        if( tweets.containsKey( userId ) )
            maxheap.add( tweets.get( userId ) );

        //merge k sorted list pattern
        //checking its following most recent tweet and adding to heap
        for( int f : followings){


            // if this user have never tweeted
            if( !tweets.containsKey( f ) ){
                continue;
            }
            Tweet recent = tweets.get( f );
            maxheap.add( recent );   //adding users most recent tweet
        }


        // heap contains most recent tweet of every following

        while( !maxheap.isEmpty() ){

            Tweet newest = maxheap.poll();          //get the most recent tweet done by particular following or him

            personalizedNewsFeed.add( newest.getTweet_id() );

            if( newest.next != null ){
                maxheap.offer( newest.next );
            }

            if( personalizedNewsFeed.size() == 10 ) return personalizedNewsFeed;
        }

        return personalizedNewsFeed;
    }

    //user A started following user B
    public void follow(int A, int B) {

        //user can not follow himself
        if( A == B ) return ;
        //new user A
        if( !userDetails.containsKey( A ) ){
            userDetails.put( A, new HashSet<>() );
        }

        // addding the user B in the following list of user A
        userDetails.get( A ).add( B );

    }

    // user A unfollowed user B
    public void unfollow(int A, int B) {

        // A already exits
        if( userDetails.containsKey(A) ){
            userDetails.get(A).remove(B);
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