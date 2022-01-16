import random
import time

players = []
print("랜덤뽑기를 시작합니다!")

while True:
    print("명단", players)
    player = input("참가자를 입력해주세요. : ")
    
    if player == '완료':
        print("최종 참가자 명단입니다.")
        print(players)
        break
    else:
        players.append(player)
time.sleep(1)
print(players, "중에서 랜덤으로 뽑힐 사람은..!!")
time.sleep(1)
print(3)
time.sleep(1)
print(2)
time.sleep(1)
print(1)
time.sleep(1)
print(random.choice(players), "당첨!!")
