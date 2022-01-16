
import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from ADR_A import *  # ADR_A의 모든 객체를 import함
from ADR_D import *
from ADR_R import *
from ADR_T import *

form_class = uic.loadUiType("ADR.ui")[0] # ui명 매우 중요!!

class ADR(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self) # 화면 셋업
    
    # 술자리 계산기 메뉴 선택 시
    def Calc(self):
      # self.hide() # 이거 하면 메인 윈도우가 꺼짐.. 
        self.af_calc = ADR_A()
        self.af_calc.show() # ARD_A의 다이얼로그창을 띄움
    
    # 더치 페이 하기 메뉴 선택 시
    def Dutch(self):
        self.dutch = ADR_D()
        self.dutch.show() # ARD_D의 다이얼로그창을 띄움
    
    # 랜덤 뽑기 게임 메뉴 선택 시
    def Random(self):
        self.random = ADR_R()
        self.random.show() # ARD_R의 다이얼로그창을 띄움

    # 총 합계 조회하기 메뉴 선택 시
    def Total(self):
        self.total = ADR_T()
        self.total.show() # ARD_T의 다이얼로그창을 띄움

    # 프로그램 종료 선택 시
    def Exit(self):
        quit() # 프로그램 종료됨!


if __name__ == '__main__':
    app = QApplication(sys.argv) 
    demoWindow = ADR()
    demoWindow.show() 
    app.exec_()