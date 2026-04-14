package ntu.kiet.quanlybanhang.Services;
import ntu.kiet.quanlybanhang.models.UserRegistrationDTO;

public interface IUserService {
    void registerNewUser(UserRegistrationDTO registrationDto);
}