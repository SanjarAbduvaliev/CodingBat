package com.example.codingbat.service;

import com.example.codingbat.entity.Language;
import com.example.codingbat.payload.ApiResponce;
import com.example.codingbat.payload.LanguageDto;
import com.example.codingbat.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    public ApiResponce addLaguage( LanguageDto languageDto){
        if (languageRepository.existsByName(languageDto.getName())){
            return new ApiResponce("Such a language exists",false);
        }
        Language language=new Language();
        language.setName(languageDto.getName());
        languageRepository.save(language);
        return new ApiResponce("Language successful added",true);
    }
    public List<Language> getAllLangage(){
        return languageRepository.findAll();
    }
    public Language getLanguageId(Integer id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()){
            return optionalLanguage.get();
        }
        return null;
    }
    public ApiResponce editLanguage(LanguageDto languageDto,Integer id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (!optionalLanguage.isPresent())
            return new ApiResponce("Not fount such a language",false);
        Language language = optionalLanguage.get();
        language.setName(languageDto.getName());
        languageRepository.save(language);
        return new ApiResponce("Laguage edited",true);
    }
    public ApiResponce deleteLanguage(Integer id){
        languageRepository.deleteById(id);
        return new ApiResponce("Deleted",true);
    }


}
