

import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
import random

form_class = uic.loadUiType("ADR_R.ui")[0] # ui명 매우 중요!!
players = {} # 전역변수로 참가자 정보를 담을 딕셔너리 생성

class ADR_R(QDialog, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self) # 화면 셋업

    # 참가자 등록 버튼 클릭에 대한 함수
    def Regist(self):
        if self.txt_num.toPlainText() == '':
            QMessageBox.about(self, 'message', '입력된 뽑기 번호가 없습니다!')
        elif self.txt_player.toPlainText() == '':
            QMessageBox.about(self,'message', '입력된 참가자 이름이 없습니다!')
        else:
            global players # 전역변수 딕셔너리 players를 사용함
            players[int(self.txt_num.toPlainText())] = self.txt_player.toPlainText()
            self.lbl_player_list.setText(str(players)) # setText()에는 문자열만 가능한 듯
            self.txt_num.setText('')     # 등록버튼 클릭과 동시에 텍스트 박스 내용이 비워지도록
            self.txt_player.setText('')  # 등록버튼 클릭과 동시에 텍스트 박스 내용이 비워지도록

    # 입력창 지우기 클릭에 대한 함수
    # def Clear(self):
    #   self.txt_num.setText('')
    #   self.txt_player.setText('')

    # 랜덤 뽑기 클릭에 대한 함수
    def Pick(self):
        global players
        r = random.randint(1, len(players)) # 딕셔너리의 길이를 마지막 랜덤 숫자범위로 설정
        self.lbl_random.setText('{0}번 {1}님이 당첨되었습니다!'.format(r, players[r]))


if __name__ == '__main__':
    app = QApplication(sys.argv) 
    demoWindow = ADR_R()
    demoWindow.show()
    app.exec_()









