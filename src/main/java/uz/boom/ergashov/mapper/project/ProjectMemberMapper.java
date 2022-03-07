package uz.boom.ergashov.mapper.project;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.project.ProjectCreateDto;
import uz.boom.ergashov.dto.project.ProjectMemberDto;
import uz.boom.ergashov.dto.project.ProjectUpdateDto;
import uz.boom.ergashov.entity.project.ProjectMember;
import uz.boom.ergashov.mapper.BaseMapper;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 23.02.2022 23:49
 * Project : etm
 */
@Component
@Mapper(componentModel = "spring")
public interface ProjectMemberMapper extends BaseMapper<
        ProjectMember,
        ProjectMemberDto,
        ProjectCreateDto,
        ProjectUpdateDto
        > {
    @Override
    ProjectMemberDto toDto(ProjectMember projectMember);


    @Override
    List<ProjectMemberDto> toDto(List<ProjectMember> e);


    @Override
    ProjectMember fromCreateDto(ProjectCreateDto projectCreateDto);


    @Override
    ProjectMember fromUpdateDto(ProjectUpdateDto projectUpdateDto);


}

