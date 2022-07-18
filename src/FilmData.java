public class FilmData {
  
  private String id;
  private String rank;
  private String title;
  private String fullTitle;
  private String year;
  private String image;
  private String crew;
  private String imDbRating;
  private String imDbRatingCount;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFullTitle() {
    return fullTitle;
  }

  public void setFullTitle(String fullTitle) {
    this.fullTitle = fullTitle;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getCrew() {
    return crew;
  }

  public void setCrew(String crew) {
    this.crew = crew;
  }

  public String getImDbRating() {
    return imDbRating;
  }

  public void setImDbRating(String imDbRating) {
    this.imDbRating = imDbRating;
  }

  public String getImDbRatingCount() {
    return imDbRatingCount;
  }

  public void setImDbRatingCount(String imDbRatingCount) {
    this.imDbRatingCount = imDbRatingCount;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FilmData other = (FilmData) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "FilmData [crew=" + crew + ", fullTitle=" + fullTitle + ", id=" + id + ", imDbRating=" + imDbRating
        + ", imDbRatingCount=" + imDbRatingCount + ", image=" + image + ", rank=" + rank + ", title=" + title
        + ", year=" + year + "]";
  }
  
}
