package com.youcode.myaftas.service.ImplService;

import com.youcode.myaftas.Exception.ResourceNotFoundException;
import com.youcode.myaftas.Utils.RankingId;
import com.youcode.myaftas.dto.RankingDto;
import com.youcode.myaftas.entities.Competition;
import com.youcode.myaftas.entities.Member;
import com.youcode.myaftas.entities.Ranking;
import com.youcode.myaftas.repositories.CompetitionRepository;
import com.youcode.myaftas.repositories.MemberRepository;
import com.youcode.myaftas.repositories.RankingRepository;
import com.youcode.myaftas.service.CompititionService;
import com.youcode.myaftas.service.RankingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingServiceImpl implements RankingService {
    @Autowired
    private RankingRepository rankingRepository;
    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CompititionService compititionService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RankingDto create(RankingDto rankingDto){
        if (compititionService.getOne(rankingDto.getCompetition_id()).getNumberOfParticipants() > rankingRepository.countByCompetitionId(rankingDto.getCompetition_id())) {

            Ranking ranking = modelMapper.map(rankingDto, Ranking.class);

            Competition competition = competitionRepository.findById(rankingDto.getCompetition_id())
                    .orElseThrow(() -> new ResourceNotFoundException("not found quiz with id : " + rankingDto.getCompetition_id()));
            ranking.setCompetition(competition);


            Member member = memberRepository.findById(rankingDto.getMember_id())
                    .orElseThrow(() -> new ResourceNotFoundException("not found member with id : " + rankingDto.getMember_id()));
            ranking.setMember(member);


            RankingId rankingId = new RankingId(
                    rankingDto.getCompetition_id(),
                    rankingDto.getMember_id()
            );

            if (rankingRepository.existsById(rankingId)) {
                throw new ResourceNotFoundException("Ranking already to the member");
            } else {
                ranking.setId(rankingId);
            }


            ranking = rankingRepository.save(ranking);
            return modelMapper.map(ranking, RankingDto.class);
        }else{
            throw new ResourceNotFoundException("Oops max this compitition is : "+compititionService.getOne(rankingDto.getCompetition_id()).getNumberOfParticipants());
        }
    }

    @Override
    public void delete(String code, Integer id){
        RankingId rankingId = new RankingId(
                code,
                id
        );

        Ranking ranking = rankingRepository.findById(rankingId)
                .orElseThrow(()-> new ResourceNotFoundException("Ranking not found with id "+id));
        rankingRepository.delete(ranking);
    }

    @Override
    public RankingDto getOne(String code, Integer id){
        RankingId rankingId = new RankingId(
                code,
                id
        );
        Ranking ranking = rankingRepository.findById(rankingId)
                .orElseThrow(() -> new ResourceNotFoundException("Ranking not found with id "+id));
        return modelMapper.map(ranking, RankingDto.class);
    }

    @Override
    public List<RankingDto> findAll() {
        return rankingRepository.findAll().stream().map(ranking -> modelMapper.map(ranking, RankingDto.class)).collect(Collectors.toList());
    }

    @Override
    public RankingDto update(String code, Integer id, RankingDto rankingDto) {
        RankingId rankingId = new RankingId(
                code,
                id
        );
        Ranking existingRanking = rankingRepository.findById(rankingId)
                .orElseThrow(() -> new ResourceNotFoundException("Ranking Not found with this: " + id));
        return modelMapper.map(rankingRepository.save(existingRanking), RankingDto.class);
    }

    @Override
    public Page<RankingDto> findWithPagination(Pageable pageable) {
        Page<Ranking> rankingPage = rankingRepository.findAll(pageable);
        return rankingPage.map(ranking -> modelMapper.map(ranking, RankingDto.class));
    }

}
