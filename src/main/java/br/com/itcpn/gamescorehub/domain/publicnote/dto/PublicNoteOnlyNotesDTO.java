package br.com.itcpn.gamescorehub.domain.publicnote.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicNoteOnlyNotesDTO {
    private Integer narrative;
    private Integer soundtrack;
    private Integer gameplay;
    private Integer animation;
}
