package com.youcode.myaftas.service.ImplService;

import com.youcode.myaftas.Exception.ResourceNotFoundException;
import com.youcode.myaftas.dto.CompetitionDto;
import com.youcode.myaftas.dto.MemberDto;
import com.youcode.myaftas.dto.rasponseDTO.CompetitionRespDto;
import com.youcode.myaftas.dto.rasponseDTO.MemberRespDto;
import com.youcode.myaftas.entities.Competition;
import com.youcode.myaftas.entities.Member;
import com.youcode.myaftas.repositories.CompetitionRepository;
import com.youcode.myaftas.service.CompititionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CompititionServiceImpl implements CompititionService {
    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CompetitionDto create(CompetitionDto competitionDto){
        Competition competition = modelMapper.map(competitionDto, Competition.class);

        competition = competitionRepository.save(competition);
        return modelMapper.map(competition, CompetitionDto.class);
    }

    @Override
    public void delete(String code){
        Competition competition = competitionRepository.findById(code)
                .orElseThrow(()-> new ResourceNotFoundException("Compitition not found with id "+code));
        competitionRepository.delete(competition);
    }

    @Override
    public CompetitionDto getOne(String code){
        Optional<Competition> competition = competitionRepository.findByCode(code);
        if (competition == null) {
            throw new ResourceNotFoundException("Competition not found with code " + code);
        }
        return modelMapper.map(competition, CompetitionDto.class);
    }

    @Override
    public List<CompetitionRespDto> getAll(){
        return Arrays.asList(modelMapper.map(competitionRepository.findAll(), CompetitionRespDto[].class));
    }

    @Override
    public CompetitionDto update(String code, CompetitionDto competitionDto){
        Competition competition = competitionRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Compitition not found with code : "+code));


        if(competitionDto.getDate() != null){
            competition.setDate(competitionDto.getDate());
        }
        if (competitionDto.getStartTime() != null){
            competition.setStartTime(competitionDto.getStartTime());
        }
        if(competitionDto.getEndTime() != null){
            competition.setEndTime(competitionDto.getEndTime());
        }
        if(competitionDto.getNumberOfParticipants() != null){
            competition.setNumberOfParticipants(competitionDto.getNumberOfParticipants());
        }
        if(competitionDto.getLocation().isEmpty() == false){
            competition.setLocation(competitionDto.getLocation());
        }
        if(competitionDto.getAmount() != null){
            competition.setAmount(competitionDto.getAmount());
        }

        competition = competitionRepository.save(competition);
        return modelMapper.map(competition, CompetitionDto.class);
    }


}
