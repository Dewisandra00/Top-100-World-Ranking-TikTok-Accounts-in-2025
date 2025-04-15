public class TikToker {
    private int rank;
    private String username;
    private long followers;
    private int following;
    private int uploads;
    private long likes;

    // Constructor
    public TikToker(int rank, String username, long followers, int following, int uploads, long likes) {
        this.rank = rank;
        this.username = username;
        this.followers = followers;
        this.following = following;
        this.uploads = uploads;
        this.likes = likes;
    }

    // Getter & Setter
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getUploads() {
        return uploads;
    }

    public void setUploads(int uploads) {
        this.uploads = uploads;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }
    

    // toString method
    @Override
    public String toString() {
        return "Rank: " + rank + ", Username: " + username + ", Followers: " + followers +
                ", Following: " + following + ", Uploads: " + uploads + ", Likes: " + likes;
    }
}
