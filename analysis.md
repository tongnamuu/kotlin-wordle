# 프로그래밍 요구사항 점검 결과

아래 항목은 README.md의 **프로그래밍 요구 사항** 기준으로 확인한 위반/미흡 사항입니다.

## 위반/미흡 항목

- **시작점 요구사항 위반**: `Application.main()`이 존재하지 않고, 최상위 `main()`만 있습니다. 시작점이 `Application`의 `main()`이어야 합니다. (`src/main/kotlin/Main.kt:9`)
- **함수 길이 15라인 초과(테스트 코드)**: 테스트 메서드들이 15라인을 넘습니다. 요구사항이 테스트 코드에도 적용된다면 위반입니다.
  - `src/test/kotlin/domain/WordleGameTest.kt:8` (17라인)
  - `src/test/kotlin/domain/WordleGameTest.kt:27` (17라인)
  - `src/test/kotlin/domain/WordleGameTest.kt:46` (17라인)
  - `src/test/kotlin/domain/WordleGameTest.kt:64` (17라인)
  - `src/test/kotlin/domain/WordleGameTest.kt:82` (16라인)
  - `src/test/kotlin/domain/WordleGameTest.kt:100` (16라인)
  - `src/test/kotlin/domain/WordleGameTest.kt:118` (16라인)
  - `src/test/kotlin/RetryableGameTest.kt:14` (31라인)
  - `src/test/kotlin/RetryableGameTest.kt:47` (32라인)
- **indent depth 2 초과(테스트 코드)**: 테스트 메서드 내부의 object 표현식 → override 함수로 인해 depth가 3 이상입니다. 요구사항이 테스트 코드에도 적용된다면 위반입니다.
  - `src/test/kotlin/RetryableGameTest.kt:18`
  - `src/test/kotlin/RetryableGameTest.kt:25`
  - `src/test/kotlin/RetryableGameTest.kt:31`
- **도메인 로직 단위 테스트 부족**: 정답 선택 로직을 담당하는 `GameInitializer`에 대한 단위 테스트가 없습니다. (`src/main/kotlin/domain/GameInitializer.kt`)
