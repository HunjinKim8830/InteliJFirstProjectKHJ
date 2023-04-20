package org.jinblog.git_test.configure;

import lombok.RequiredArgsConstructor;
import org.jinblog.git_test.entity.AuthorityEntity;
import org.jinblog.git_test.entity.MemberEntity;
import org.jinblog.git_test.repository.AuthorityRepository;
import org.jinblog.git_test.repository.MemberRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberAuthenticationProvider implements AuthenticationProvider {
    private final MemberRepository memberRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(!supports(authentication.getClass())){
            return null;
        }

        //2.사용자 정보 DB로부터 조회
        String id = authentication.getName();//사용자가 로그인시 입력한 ID 반환
        System.out.println("아이디출력"+id);
        String password=(String) authentication.getCredentials();//사용자가 입력한 패스워드 반환
        System.out.println("비밀번호"+password);

        Optional<MemberEntity> memberOptional = memberRepository.findById(id);
        System.out.println("멤버옵셔널"+memberOptional);
        MemberEntity memberEntity = memberOptional.get();
        System.out.println("멤버엔티티"+memberEntity);
        if(memberEntity == null){
            System.out.println("회원아이디가 없습니다.");
            throw new UsernameNotFoundException("회원 아이디가 존재하지 않습니다");

        }

		/*
        if (passwordEncoder.matches(password, account.getPassword())) {//! 비밀번호가 일치하지 않으면
            System.out.println("비번불일치");
        	throw new BadCredentialsException("비밀번호가 일치하지 않습니다");

        }
        */
        if (!password.equals(memberEntity.getPassword())) {//! 비밀번호가 일치하지 않으면
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다");

        }

        //4.사용자 권한 조회
        Optional<AuthorityEntity> authorityOptional = authorityRepository.findById(id);
        AuthorityEntity authorityEntity = authorityOptional.get();



        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(authorityEntity.getRole()));
        MemberEntity nameEntity = new MemberEntity(id, memberEntity.getName(), memberEntity.getNickname());
        Authentication auth = new UsernamePasswordAuthenticationToken(nameEntity, password, authorities);
        return auth;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
