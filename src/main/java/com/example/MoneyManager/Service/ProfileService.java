package com.example.MoneyManager.Service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.MoneyManager.Dto.ProfileDTO;
import com.example.MoneyManager.Entity.ProfileEntity;
import com.example.MoneyManager.Repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    public  ProfileDTO registerProfile(ProfileDTO profileDTO)
    {
        ProfileEntity newProfile = toEntity(profileDTO);
        newProfile.setActivationToken(UUID.randomUUID().toString());
        profileRepository.save(newProfile);
        return toDTO(newProfile);
    }
    public ProfileEntity toEntity(ProfileDTO profileDTO)
    {
        return ProfileEntity.builder()
                .id(profileDTO.getId())
                .fullName(profileDTO.getFullName())
                .email(profileDTO.getEmail())
                .password(profileDTO.getPassword())
                .profileImageUrl(profileDTO.getProfileImageUrl())
                .createdAt(profileDTO.getCreatedAt())
                .updatedAt(profileDTO.getUpdatedAt())
                .build();
    }
    public ProfileDTO toDTO(ProfileEntity profileEntity)
    {
        return ProfileDTO.builder()
                .id(profileEntity.getId())
                .fullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .profileImageUrl(profileEntity.getProfileImageUrl())
                .createdAt(profileEntity.getCreatedAt())
                .updatedAt(profileEntity.getUpdatedAt())
                .build();
    }

}
