package com.example.services;

import com.example.repositories.UserRepository;
import com.example.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//Данный классс
//является реализацией интерфейса UserDetailsService, который используется в Spring Security
//для загрузки пользовательских данных (например, учетных записей пользователей) во время
//процесса аутентификации.
//
//В методе loadUserByUsername(String username) происходит поиск пользователя по его имени
//пользователя (username) в репозитории пользователей (UserRepository).
//Если пользователь найден, его данные используются для создания объекта CustomUserDetails,
//который представляет расширенные сведения о пользователе и включает в себя информацию,
//необходимую для аутентификации и авторизации, например, учетные данные и права доступа

@Service
public class CustomUserServiceDetails implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        var user = userRepository.findByUsername(username);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
