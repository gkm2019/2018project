package evaluation;

public class EvaluationDTO {

   int evaluationID;
   String userID;
   String age;
   String reviewDivide;
   String evaluationTitle;
   String evaluationContent;
   String totalScore;
   String recomendScore;
   int likeCount;
   int course_idx;
   
   public int getEvaluationID() {
      return evaluationID;
   }
   public void setEvaluationID(int evaluationID) {
      this.evaluationID = evaluationID;
   }
   public String getUserID() {
      return userID;
   }
   public void setUserID(String userID) {
      this.userID = userID;
   }
   public String getAge() {
      return age;
   }
   public void setAge(String age) {
      this.age = age;
   }
   public String getReviewDivide() {
      return reviewDivide;
   }
   public void setReviewDivide(String reviewDivide) {
      this.reviewDivide = reviewDivide;
   }
   
   public String getEvaluationTitle() {
      return evaluationTitle;
   }
   public void setEvaluationTitle(String evaluationTitle) {
      this.evaluationTitle = evaluationTitle;
   }
   public String getEvaluationContent() {
      return evaluationContent;
   }
   public void setEvaluationContent(String evaluationContent) {
      this.evaluationContent = evaluationContent;
   }
   public String getTotalScore() {
      return totalScore;
   }
   public void setTotalScore(String totalScore) {
      this.totalScore = totalScore;
   }
   public String getRecomendScore() {
      return recomendScore;
   }
   public void setRecomendScore(String recomendScore) {
      this.recomendScore = recomendScore;
   }
   public int getLikeCount() {
      return likeCount;
   }
   public void setLikeCount(int likeCount) {
      this.likeCount = likeCount;
   }
   public int getcourse_idx() {
      return course_idx;
   }
   public void setcourse_idx(int course_idx) {
      this.course_idx = course_idx;
   }
   public EvaluationDTO() {
      
   }
   
   
   public EvaluationDTO(int evaluationID, String userID, String age, String reviewDivide,
         String evaluationTitle, String evaluationContent, String totalScore, String recomendScore, int likeCount
         , int course_idx) {
      super();
      this.evaluationID = evaluationID;
      this.userID = userID;
      this.age = age;
      this.reviewDivide = reviewDivide;
      this.evaluationTitle = evaluationTitle;
      this.evaluationContent = evaluationContent;
      this.totalScore = totalScore;
      this.recomendScore = recomendScore;
      this.likeCount = likeCount;
      this.course_idx =course_idx;
   }
   
   
}