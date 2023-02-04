package com.malibin.study.domain.lotto.ticket

import com.google.common.truth.Truth.assertThat
import com.malibin.study.domain.lotto.LottoNumber
import com.malibin.study.domain.lotto.result.Prize
import org.junit.jupiter.api.Test

class WinningTicketTest {
    @Test
    fun `보너스 번호와 당첨 번호는 중복 될 수 없다`() {
        val targetNumbers = LottoTicket(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.of(5)

        val assertException = runCatching { WinningTicket(targetNumbers, bonusNumber) }.exceptionOrNull()

        assertThat(assertException)
            .hasMessageThat()
            .contains("보너스 번호 (5)는 당첨번호(1, 2, 3, 4, 5, 6)와 중복될 수 없습니다.")
    }

    @Test
    fun `한 개의 로또 티켓의 당첨 등수를 잘 반환한다`() {
        val winningTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val bonus = LottoNumber.of(7)
        val otherTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        val assertValue = WinningTicket(winningTicket, bonus).compareWith(otherTicket)

        assertThat(assertValue).isEqualTo(Prize.First)
    }

    @Test
    fun `여러 개의 로또 티켓들의 당첨 등수와 당첨된 티켓의 갯수를 잘 반환한다`() {
        val winningTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val bonus = LottoNumber.of(7)

        val ticket1 = LottoTicket(1, 2, 3, 8, 9, 10)
        val ticket2 = LottoTicket(1, 2, 3, 4, 5, 6)
        val ticket3 = LottoTicket(1, 2, 3, 4, 5, 7)
        val comparedTickets = listOf(ticket1, ticket2, ticket3)

        val assertValue = WinningTicket(winningTicket, bonus).compareWith(comparedTickets)

        val expectValue = mapOf<Prize, Int>(
            Prize.Fifth to 1,
            Prize.First to 1,
            Prize.Second to 1
        )

        assertThat(assertValue).isEqualTo(expectValue)
    }
}