-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydbreview
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pjt5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pjt5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pjt5` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pjt5` ;

-- -----------------------------------------------------
-- Table `pjt5`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pjt5`.`user` (
  `user_id` VARCHAR(255) NOT NULL,
  `user_pw` VARCHAR(45) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `birth` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `userId_UNIQUE` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pjt5`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pjt5`.`video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `part` VARCHAR(255) NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `view_cnt` INT NOT NULL,
  `regist_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_user_video_idx` (`regist_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_video`
    FOREIGN KEY (`regist_id`)
    REFERENCES `pjt5`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pjt5`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pjt5`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `writer` VARCHAR(255) NOT NULL,
  `content` TEXT NOT NULL,
  `view_cnt` INT NOT NULL DEFAULT '0',
  `reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `video_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_video_review_idx` (`video_id` ASC) VISIBLE,
  CONSTRAINT `fk_video_review`
    FOREIGN KEY (`video_id`)
    REFERENCES `pjt5`.`video` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 1. 유저 더미 데이터
INSERT INTO user (user_id, user_pw, user_email, gender, birth)
VALUES 
('thankyou123', 'pw1234', 'bubu@example.com', '여', '1990-01-01'),
('fitnessfan123', 'pw5678', 'fan@example.com', '여', '1995-05-05'),
('ssafykim', 'pw1111', 'kim@ssafy.com','남', '2000-02-03'),
('ssafypark', 'pw2222', 'lee@ssafy.com', '남', '2002-05-31');

-- 2. 비디오 더미 데이터
INSERT INTO video (title, part, url, view_cnt, regist_id)
VALUES
('2주만에 복근 만드는 운동 2 MIN ABS WORKOUT', '복근', 'https://www.youtube.com/watch?v=PoYzxj8Iy5M', 0, 'Thankyou BUBU'),
('전신 다이어트 최고의 운동 [칼소폭 마라맛🔥]', '전신', 'https://www.youtube.com/watch?v=F-Jd4kI6rdM', 0, 'Thankyou BUBU'),
('5분! 팔뚝살 빨리빼는운동 / 상체 다이어트 [팔뚝살 마라맛🔥]', '상체', 'https://www.youtube.com/watch?v=MEzTdtFdfbI', 0, 'Thankyou BUBU');

-- 3. 리뷰 더미 데이터
INSERT INTO review (title, writer, content, view_cnt, video_id)
VALUES
('복근 운동 후기', '김싸피', '정말 효과 좋네요! 2주 만에 복근이 보입니다.', 0, 7),
('전신 운동 최고', 'FitnessFan', '칼소폭 마라맛이라고 해서 기대했는데 정말 힘들지만 재미있어요.', 0, 8),
('팔뚝살 감소 성공', '박싸피', '5분만에 팔뚝살이 눈에 띄게 줄었어요!', 0, 9);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;