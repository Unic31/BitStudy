import pygame
import time
import webbrowser

# pygame 초기화
pygame.init()
width, height = 600, 600
window = pygame.display.set_mode((width, height))
clock = pygame.time.Clock()

# 히오스마크 이미지 로드
hos_image = pygame.image.load("hos_logo.png")
hos_image = pygame.transform.scale(hos_image, (250, 250))
hos_rect = hos_image.get_rect(center=(width // 2, height // 2))

# 애니메이션 및 이동 변수
rotation_angle = 0
rotation_speed = 2
start_time = time.time()
link_opened = False

# 메인 루프
while not link_opened:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            link_opened = True

# 히오스마크 회전
rotated_image = pygame.transform.rotate(hos_image, rotation_angle)
rotated_rect = rotated_image.get_rect(center=hos_rect.center)

# 화면 업데이트
window.fill((255, 255, 255))
window.blit(rotated_image, rotated_rect)
pygame.display.flip()
clock.tick(60)

# 회전 각도 업데이트
rotation_angle += rotation_speed

# 일정 시간이 지나면 링크 열기
elapsed_time = time.time() - start_time
if elapsed_time > 2:  # 2초 후에 링크 열기
    webbrowser.open("https://heroesofthestorm.com/ko-kr/")
    link_opened = True

# pygame 종료
pygame.quit()
