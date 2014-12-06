package astylesstuff.world;

import java.util.Set;

import astylesstuff.util.ChunkCoord;

public interface ISuspendableGen
{
    public Set<ChunkCoord> getChunksToGen();

    public boolean doGeneration(int chunkX, int chunkZ);
}
