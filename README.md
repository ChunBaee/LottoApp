### 1단계 기능목록

#### Money
1. 입력 금액이 음수일 때 잘 걸러내는지?
2. 입력 금액이 0 혹은 Null은 아닌지? 
   -> Money의 코드에서 0은 합격인데 걸러야 하지 않는지?, 입력값 null 체크는 어떻게 해야하는지?
3. 입력 금액에 문자가 들어올 때 잘 걸러내는지?
4. plus, minus operator 함수는 잘 동작하는지? -> 연산에 에러가 없는지?


#### LottoNumber
1. 입력금액이 정상일 때 잘 동작하는지?
2. 입력금액이 비정상일 때 (범위보다 큰/작은 수)일때 예외처리를 잘 하는지?


#### LottoTicket
1. 로또번호가 중복값이 있을 때 예외처리를 잘 하는지?
2. 로또번호가 6개가 아닐 때 (작을 때 / 많을 때) 예외처리를 잘 하는지? (에러메시지에 입력값들이 정확히 보이는지?)
3. 로또번호들 안에 특정 숫자가 있을 때 잘 찾아내는지? (has)
4. 로또번호들 사이의 중복된 값의 갯수를 잘 찾아내는지? (countMatchingNumbers)

### 2단계 기능목록

#### Prize
1. 당첨됐을 때 정상적으로 잘 동작하는지?
2. 미당첨됐을 때 정상적으로 잘 동작하는지?
3. 당첨된 수가 0일 때, 보너스 당첨여부가 true일 경우, 예외처리가 되는지?

#### WinningTicket
1. 보너스번호와 당첨번호가 중복일 때 잘 걸러내는지?
2. 당첨번호와 다른 티켓들을 주었을 때 잘 찾아내는지? (compareWith)