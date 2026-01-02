#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> storage, vector<string> requests) {
    int H=storage.size(), W=storage[0].size();
    vector<string> g=storage;
    auto in=[&](int y,int x){return 0<=y&&y<H&&0<=x&&x<W;};

    auto outside=[&](){
        vector<vector<int>> out(H,vector<int>(W,0));
        queue<pair<int,int>> q;
        // 경계의 '.'에서 시작
        for(int y=0;y<H;y++){
            for(int x=0;x<W;x++){
                if((y==0||y==H-1||x==0||x==W-1) && g[y][x]=='.'){
                    out[y][x]=1; q.push({y,x});
                }
            }
        }
        int dy[4]={-1,1,0,0}, dx[4]={0,0,-1,1};
        while(!q.empty()){
            auto [cy,cx]=q.front(); q.pop();
            for(int d=0; d<4; ++d){
                int ny=cy+dy[d], nx=cx+dx[d];
                if(in(ny,nx) && g[ny][nx]=='.' && !out[ny][nx]){
                    out[ny][nx]=1; q.push({ny,nx});
                }
            }
        }
        return out;
    };

    for(const string& req : requests){
        char c=req[0];
        if(req.size()==2){
            // 크레인: 해당 문자 전부 제거
            for(int y=0;y<H;y++)
                for(int x=0;x<W;x++)
                    if(g[y][x]==c) g[y][x]='.';
        }else{
            // 지게차: 테두리 or 외부 공기와 접한 것만 제거
            auto out=outside();
            int dy[4]={-1,1,0,0}, dx[4]={0,0,-1,1};
            vector<pair<int,int>> rem;

            for(int y=0;y<H;y++){
                for(int x=0;x<W;x++){
                    if(g[y][x]!=c) continue;

                    bool exposed = false;

                    // ① 테두리 접촉이면 바로 노출
                    if(y==0 || y==H-1 || x==0 || x==W-1) {
                        exposed = true;
                    } else {
                        // ② 외부와 연결된 빈칸과 변 접촉?
                        for(int d=0; d<4 && !exposed; ++d){
                            int ny=y+dy[d], nx=x+dx[d];
                            if(in(ny,nx) && g[ny][nx]=='.' && out[ny][nx]) exposed = true;
                        }
                    }
                    if(exposed) rem.push_back({y,x});
                }
            }
            // 한 번에 제거(같은 요청 내 연쇄 방지)
            for(auto &p: rem) g[p.first][p.second]='.';
        }
    }

    int remain=0;
    for(auto &row: g) for(char ch: row) if(ch!='.') remain++;
    return remain;
}
