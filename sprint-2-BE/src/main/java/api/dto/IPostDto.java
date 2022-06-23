package api.dto;

public interface IPostDto {
     Long getId();

     String getImage();

     String getPostDate();

     String getPrivacy();

     String getFeeling();

     String getContent();

     Long getGuestId();

     String getName();

     String getImageGuest();

     Integer  getTotalLike();
}
