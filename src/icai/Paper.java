/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icai;

/**
 *
 * @author admin
 */
public class Paper {

    private int paperId;
    private String paperTopic;
    private String author;
    private String date;
    private String Rank;

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperTopic() {
        return paperTopic;
    }

    public void setPaperTopic(String paperTopic) {
        this.paperTopic = paperTopic;
    }

    public Paper(int paperId,
            String paperTopic,String author,String date,String rank) {
        this.paperId=paperId;
        this.paperTopic=paperTopic;
        this.author=author;
        this.date=date;
        this.Rank=rank;
    }


}
