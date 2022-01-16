
import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from ADR_A_status import *  # 주류 및 안주 입력현황 조회를 위해 import

form_class = uic.loadUiType("ADR_A.ui")[0] # ui명 매우 중요!!

d_dict = {} # 전역변수로 주류 정보를 담을 딕셔너리 생성 / 전역변수로 안하면 합계 계산할때 변수 사용이 어려웠음
f_dict = {} # 전역변수로 안주 정보를 담을 딕셔너리 생성 / 전역변수로 안하면 합계 계산할때 변수 사용이 어려웠음
#a_total = 0
#f_total = 0

class ADR_A(QDialog, form_class):
    
    def __init__(self):
        super().__init__()
        self.setupUi(self) # 화면 셋업

    # 술자리 계산기 메뉴 선택 시
    def Drink(self): # 주류 정보 입력에 대한 함수

        # 공란으로 입력버튼 클릭 시 팝업 메세지 나오도록(PyQt 수업 참고)
        if self.txt_d_name.toPlainText() == '' or self.txt_d_price.toPlainText() == '' or self.txt_d_amount.toPlainText() == '':
            QMessageBox.about(self, 'message', '입력된 주류 정보가 없습니다!')
        
        # 공란이 아닌 내용을 입력했을 시에 대한 처리
        else:
            # 주류 딕셔너리 작성      
            global d_dict # 전역변수 d_dict 사용
            d_dict[self.txt_d_name.toPlainText()] = (int(self.txt_d_amount.toPlainText()) * int(self.txt_d_price.toPlainText()))

            # 입력 버튼 클릭 시 라벨에 띄울 문구(주류 정보)
            self.lbl_d_status.setText('{0} {1}병 총 {2}원 입니다.'.
            format(self.txt_d_name.toPlainText(), self.txt_d_amount.toPlainText(), 
            (int(self.txt_d_price.toPlainText())*int(self.txt_d_amount.toPlainText()))))



    def Food(self): # 안주 정보 입력에 대한 함수

        # 공란으로 입력버튼 클릭 시 팝업 메세지 나오도록(PyQt 수업 참고)
        if self.txt_f_name.toPlainText() == '' or self.txt_f_price.toPlainText() == '':
            QMessageBox.about(self, 'message', '입력된 안주 정보가 없습니다!')

        # 공란이 아닌 내용을 입력했을 시에 대한 처리
        else:
            # 안주 딕셔너리 작성
            global f_dict # 전역변수 f_dict 사용
            f_dict[self.txt_f_name.toPlainText()] = int(self.txt_f_price.toPlainText())

            # 입력 버튼 클릭 시 라벨에 띄울 문구(안주 정보)
            self.lbl_f_status.setText('{0} {1}원 입니다.'.format(self.txt_f_name.toPlainText(), self.txt_f_price.toPlainText()))



        
    def Af_total(self): # 총 합계에 대한 함수(ADR_D, ADR_T에서도 활용됨)
        # 주류 총 합계 
        d_total = 0
        for i in d_dict:
            d_total += d_dict[i] # d_total에 주류 딕셔너리에 있는 밸류를 계속 더해줌

        # 안주 총 합계
        f_total = 0
        for j in f_dict:
            f_total += f_dict[j] # f_total에 음주 딕셔너리에 있는 밸류를 계속 더해줌

        t_result = d_total + f_total
        self.lbl_result.setText('총 합계 금액 {0}원 입니다.'.format(t_result))

        return t_result # 다른 파일에서도 사용하기 위해 return으로 둠(타 파일에서 import시 함수 호출로 바로 값 가져올 수 있도록)

    # 입력창 비우기 클릭에 대한 함수
    def Clear(self):
        self.txt_d_name.setText('')
        self.txt_d_price.setText('')
        self.txt_d_amount.setText('')
        self.txt_f_name.setText('')
        self.txt_f_price.setText('')
        self.lbl_d_status.setText('')
        self.lbl_f_status.setText('')
        self.lbl_result.setText('')

    # 안주 및 주류 입력현황 조회 클릭에 대한 함수
    def Status(self):
        self.win_status = ADR_A_status()
        self.win_status.Label_update(d_dict, f_dict) # Label_update 함수의 매개변수로 주류,안주 딕셔너리 할당
        self.win_status.show() # 입력 현황 다이얼로그를 화면에 띄움

    # 종료 버튼 클릭 시 -> 이거 하면 메인 윈도우까지 다 꺼짐..
    #def Quit(self):
    #    quit()


if __name__ == '__main__':
    app = QApplication(sys.argv) 
    demoWindow = ADR_A() # demoWindow 변수에 DemoForm함수를 할당
    demoWindow.show() # demoWindow를 화면에 띄움
    app.exec_()